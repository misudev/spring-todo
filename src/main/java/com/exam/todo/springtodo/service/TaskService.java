package com.exam.todo.springtodo.service;

import com.exam.todo.springtodo.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    // Task 추가
    public Task addTask(Task task);
    // Task 하나 가져오기
    public Task getTask(Long taskId);
    // Task 목록 가져오기
    public Page<Task> getTasks(int page);
    // Task 삭제하기
    public void deleteTask(Long taskId);
    // Task 수정하기
    public void updateTask(Task task);
    // Task 완료처리
    public void updateTaskComplete(Long taskId);
    // 마감 기한이 지났는데 완료되지 못한 task 가져오기.
    public List<Task> getPastTask();
    // 마감 기한 지난 Task check
    public void updateTaskTimeOver(Long taskId);
    // 마감 기한이 안 지난 Task 가져오기
    public List<Task> getTasksByTimeOver();
}
