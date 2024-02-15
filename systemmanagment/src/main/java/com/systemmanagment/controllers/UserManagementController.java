package com.systemmanagment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.systemmanagment.models.User;
import com.systemmanagment.repositories.UserRepository;


@Controller
@RequestMapping("/user")
public class UserManagementController {

    private UserRepository userRepository;

    @Autowired
    public UserManagementController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    @PostMapping(value = "/create")    
    public ResponseEntity<User> createUser(@RequestBody User request) {
        try {
            String id = request.id;

            String firstName = request.firstName;
            String lastName = request.lastName;
            String email = request.email;
            String password = request.password;

            User newUser = new User(id, firstName, lastName, email, password);
            
            userRepository.save(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED); 
        } catch(Exception exception) {
            this.handlerException(exception);
            return null;
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List <User>> getAllUsers() {
        List<User> usersList = userRepository.findAll();
        return new ResponseEntity<>(usersList, HttpStatus.CREATED);
    }

    @ExceptionHandler()
    private ResponseEntity<Exception> handlerException(Exception exception) {   
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
