package com.tricon.todo.services;

import com.tricon.todo.TodoModel;
import com.tricon.todo.exceptions.TodoCollectionException;

import javax.validation.ConstraintViolationException;

public interface TodoService {
    void createTodo(TodoModel todo) throws ConstraintViolationException,TodoCollectionException;
}
