package com.tricon.todo;

import com.tricon.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    public TodoRepository repository;

    @Autowired
    public TodoService todoService;

    @GetMapping(value = "/todos")
    public ResponseEntity<?> getAllTodos(){
        List<TodoModel> todos = repository.findAll();
        if(todos.size() > 0){
            return new ResponseEntity<List<TodoModel>>(todos, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No Data found",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") String id){
        try {
            Optional<TodoModel> todo = repository.findById(id);
            if(todo.isPresent()){
                return new ResponseEntity<>(todo.get(),HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Todo not found with id " + id,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/todos")
    public ResponseEntity<?> createTodos(@RequestBody TodoModel body){
        try{
            todoService.createTodo(body);
            return new ResponseEntity<TodoModel>(body,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/todos/{id}")
    public ResponseEntity<?> updateOne(@PathVariable("id") String id, @RequestBody TodoModel body){
        try {
            Optional<TodoModel> todo = repository.findById(id);
            if(todo.isPresent()){
                TodoModel todoToSave = todo.get();
                todoToSave.setTodo(body.getTodo() != null ? body.getTodo() : todoToSave.getTodo());
                todoToSave.setStatus(body.getStatus() != null ? body.getStatus() : todoToSave.getStatus());
                todoToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
                repository.save(todoToSave);
                return new ResponseEntity<>(todoToSave,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Todo not found with id " + id,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/todos/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable("id") String id){
        try {
            Optional<TodoModel> todo = repository.findById(id);
            if(todo.isPresent()){
                repository.deleteById(id);
                return new ResponseEntity<>("Successfully deleted todo!",HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Todo not found with id " + id,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
