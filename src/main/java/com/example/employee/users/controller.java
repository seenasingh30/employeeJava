package com.example.employee.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class controller {
    @Autowired
    public repository repo;
    // get all data
    @GetMapping(value = "/" )
    public String getAll(){
        return "Wellcome to Employee API";
    }
    @GetMapping(value = "/users")
    public List<model> gets(){
        return repo.findAll();
    }
    @GetMapping(value = "/users/{id}")
    public Optional<model> getById(@PathVariable int id){
        return repo.findById(id);
    }

    @PostMapping(value = "/users")
    public String create(@RequestBody model body){
        repo.save(body);
        return "done";
    }
    @GetMapping(value = "/users")
    public Optional<model> update(@RequestBody model m){
        repo.save(m);
        return repo.findById(m.getId());
    }
    @DeleteMapping(value = "/users/{id}")
    public String Delete(@PathVariable int id){
        repo.deleteById(id);
        return "Deleted";
    }

}
