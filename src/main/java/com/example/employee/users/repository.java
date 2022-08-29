package com.example.employee.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.employee.users.model;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends MongoRepository<model,Long> {
}
