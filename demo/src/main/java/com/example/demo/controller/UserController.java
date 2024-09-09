package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import java.util.List;
import com.example.demo.repository.UserRepo;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/users/add")
    public User post(@RequestBody User user){
        this.userRepo.save(user);
        return user;
    }

    @GetMapping("/users/get")
    public List<User> list(){
        return this.userRepo.findAll();
    }
    
}
