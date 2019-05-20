package com.exam.todo.springtodo.scheduler;

import com.exam.todo.springtodo.domain.Task;
import com.exam.todo.springtodo.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class TaskCheckScheduler {
    private final TaskService taskService;
    // 00시 마다 마감 날짜 지났는지 체크
    @Scheduled(cron= "0 0 21 * * *")
    public void checkOverTime(){
        log.info("마감기한 체크 시작!");
        List<Task> targetTasks = taskService.getTasksByTimeOver();
        Date now = new Date();
        // 오늘 날짜와 비교하여 마감 기한이 지난 경우 timeOver 값을 true로 바꿔준다.
        for(Task t : targetTasks){
            Date deadline = t.getDeadlineDate();
            if(deadline.before(now)){
                log.info("task time over : {}", t.getTitle());
                taskService.updateTaskTimeOver(t.getId());
            }
        }
    }
}
