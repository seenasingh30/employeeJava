package com.tricon.todo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<TodoModel,String> {
    @Query("{'todo' : '?0'}")
    Optional<TodoModel> findByTodo(String todo);
}
