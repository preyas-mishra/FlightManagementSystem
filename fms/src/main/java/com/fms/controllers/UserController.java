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

@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/users/email/{userEmail}")
    public User viewUserbyEmail(@PathVariable ("userEmail") String userEmail)
    {
        return userServiceImpl.viewUserByEmail(userEmail);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User newUser)
    {
        User user=userServiceImpl.addUser(newUser);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User updateUser)
    {

        User user=userServiceImpl.updateUser(updateUser);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable ("userId") BigInteger userId)
    {
        userServiceImpl.deleteUser(userId);
    }
}
