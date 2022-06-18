package com.demo.rest.webservices.restfulwebservices.controller;

import com.demo.rest.webservices.restfulwebservices.dao.UserDAO;
import com.demo.rest.webservices.restfulwebservices.entity.User;
import com.demo.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDAO.getUsers();
    }

    @GetMapping(path = "/users/{userId}")
    public User getUser(@PathVariable int  userId) {
        User user = userDAO.getUser(userId);

        if (user == null) {
            throw new UserNotFoundException("Id : " + userId);
        }
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User createdUser = userDAO.saveUser(user);
        URI createdUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(createdUri).build();
    }

    @DeleteMapping(path = "/users/{userId}")
    public void deleteUser(@PathVariable int  userId) {
        User user = userDAO.deleteUserById(userId);

        if (user == null) {
            throw new UserNotFoundException("Id : " + userId);
        }
        
    }


}
