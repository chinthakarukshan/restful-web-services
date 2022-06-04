package com.demo.rest.webservices.restfulwebservices.controller;

import com.demo.rest.webservices.restfulwebservices.dao.UserDAO;
import com.demo.rest.webservices.restfulwebservices.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return userDAO.getUser(userId);
    }

    @PostMapping(path = "/users")
    public void createUser(@RequestBody User user) {
        User createdUser = userDAO.saveUser(user);
    }
}
