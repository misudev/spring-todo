package com.exam.todo.springtodo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IdDto {
    @NotNull
    private long id;
}
