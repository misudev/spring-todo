package com.exam.todo.springtodo.controller;

import com.exam.todo.springtodo.domain.Task;
import com.exam.todo.springtodo.dto.IdDto;
import com.exam.todo.springtodo.dto.TaskDto;
import com.exam.todo.springtodo.service.TaskService;
import com.exam.todo.springtodo.util.ParseDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskApiController {
    private final TaskService taskService;

    // task 하나 가져오기
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable("taskId") Long taskId){
        Task task = taskService.getTask(taskId);
        if(task == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    // task page 별로 가져오기
    @GetMapping
    public ResponseEntity<Page<Task>> getTasks(@RequestParam(name = "page", required = false, defaultValue = "1") int page){
        if(page < 1)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Page<Task> tasks = taskService.getTasks(page - 1);
        if(tasks.getTotalPages() < page)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // task 추가하기
    @PostMapping
    public ResponseEntity addTask(@RequestBody TaskDto taskDto){
        Task newTask = mappingTask(taskDto);
        taskService.addTask(newTask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // task complete 값 바꾸기
    @PutMapping
    public ResponseEntity changeComplete(@RequestBody IdDto idDto){
        taskService.updateTaskComplete(idDto.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    // task 수정하기
    @PutMapping("/{taskId}")
    public ResponseEntity updateTask(@RequestBody TaskDto taskDto){
        if(taskDto.getId() == 0L) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Task updateTask = mappingTask(taskDto);
        Task beforeTask = taskService.getTask(taskDto.getId());
        // 생성 날짜와 상태는 바꾸지 않는다.
        updateTask.setCreatedDate(beforeTask.getCreatedDate());
        updateTask.setComplete(beforeTask.isComplete());
        // 만약 timeover가 true인 경우 deadline이 그대로 지난 기한이면 updateTask의 timeOver을 true로 바꿔준다.
        if(beforeTask.isTimeOver()){
            if(updateTask.getDeadlineDate().before(new Date())){
                updateTask.setTimeOver(true);
            }
        }
        taskService.updateTask(updateTask);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    // task 삭제하기
    @DeleteMapping("/{taskId}")
    public ResponseEntity deleteTask(@PathVariable("taskId") Long taskId){
        if(taskService.getTask(taskId)==null)
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        taskService.deleteTask(taskId);
        return new ResponseEntity(HttpStatus.OK);
    }

    private Task mappingTask(TaskDto taskDto){
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setPriority(taskDto.getPriority());
        task.setDeadlineDate(ParseDate.stringToDate(taskDto.getDeadlineDate()));
        return task;
    }
}
