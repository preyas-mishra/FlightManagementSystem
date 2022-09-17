package com.fms.controllers;

import com.fms.dtos.User;
import com.fms.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public List<User> viewUser()
    {
        return userServiceImpl.viewUser();
    }

    @GetMapping("/users/{userId}")
    public User viewUser(@PathVariable ("userId") BigInteger userId)
    {
        return userServiceImpl.viewUser(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User newUser)
    {
        userServiceImpl.addUser(newUser);
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User updateUser)
    {

        userServiceImpl.updateUser(updateUser);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId")BigInteger  userId)
    {
        userServiceImpl.deleteUser(userId);
    }
}
