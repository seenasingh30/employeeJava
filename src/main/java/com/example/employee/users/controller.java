package com.example.employee.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.employee.users.model;
import java.util.List;

@RestController
public class controller {
    @Autowired
    public repository repo;
    // get all data
    @GetMapping(value = "/" )
    public List<model> getAll(){
        return repo.findAll();
    }

    @PostMapping(value = "/")
    public String create(){
        return "done";
    }
}
