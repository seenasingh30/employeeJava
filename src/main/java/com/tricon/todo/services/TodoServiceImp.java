package com.tricon.todo.services;

import com.tricon.todo.TodoModel;
import com.tricon.todo.TodoRepository;
import com.tricon.todo.exceptions.TodoCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Optional;

@Service
public class TodoServiceImp implements TodoService{

    @Autowired
    public TodoRepository repository;

    @Override
    public void createTodo(TodoModel todo) throws ConstraintViolationException , TodoCollectionException {
        Optional<TodoModel> todoModelOptional = repository.findByTodo(todo.getTodo());
        if (todoModelOptional.isPresent()){
            throw new TodoCollectionException(TodoCollectionException.TodoExists());
        }
        else {
            todo.setCreatedAt(new Date(System.currentTimeMillis()));
            repository.save(todo);
        }
    }
}
