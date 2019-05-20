package com.exam.todo.springtodo.repository;

import com.exam.todo.springtodo.domain.Task;
import com.exam.todo.springtodo.util.ParseDate;
import com.exam.todo.springtodo.util.PriorityType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @Before
    public void setUp() throws Exception {
        Task task = new Task();
        task.setTitle("책 반납");
        task.setDescription("스프링 책 반납하기");
        task.setPriority(PriorityType.High);
        taskRepository.save(task);
    }

    @Test
    public void task_가져오기() throws Exception {
        Task task = taskRepository.getTaskById(3L);
        assertEquals(task.getTitle(), "책 반납");
        assertEquals(task.getDeadlineDate(), ParseDate.createLastDate());
    }

    @Test
    public void task_timeover_가져오기() throws Exception{
        List<Task> tasks = taskRepository.getTasksByTimeOver();
    }

}