package com.exam.todo.springtodo.repository;

import com.exam.todo.springtodo.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.id =:id")
    public Task getTaskById(@Param("id")Long id);

    @Modifying
    @Query("DELETE FROM Task t WHERE t.id =:id")
    public void deleteTaskById(@Param("id")Long id);

    @Query("SELECT t FROM Task t WHERE t.timeOver = 1 AND t.complete = 0")
    public List<Task> getTasksByTimeOverIsTrueAndCompleteIsFalse();

    @Query("SELECT t FROM Task t WHERE t.timeOver = 0")
    public List<Task> getTasksByTimeOver();


}
