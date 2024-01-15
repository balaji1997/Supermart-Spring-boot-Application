package com.example.Supermart.controller;
import com.example.Supermart.model.Supermart;
import com.example.Supermart.model.User;
import com.example.Supermart.repo.SupermartRepo;
import com.example.Supermart.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usersList;
        try {
            usersList = new ArrayList<>();
            userRepo.findAll().forEach(usersList::add);
            if (usersList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> userData= userRepo.findById(id);
        if (userData.isPresent()){
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User userDetails){
        User userObj=userRepo.save(userDetails);
        return new ResponseEntity<>(userObj , HttpStatus.OK);
    }
    //!!!!!!!Update and delete needs to be added here....
}
