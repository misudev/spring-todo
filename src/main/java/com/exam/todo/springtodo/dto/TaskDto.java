package com.exam.todo.springtodo.dto;

import com.exam.todo.springtodo.util.PriorityType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class TaskDto {
    private Long id;
    @NotNull
    private String title;

    private String description;

    @NotNull
    private PriorityType priority;

    private String deadlineDate;
}
