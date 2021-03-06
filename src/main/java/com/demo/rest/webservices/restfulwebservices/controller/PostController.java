package com.demo.rest.webservices.restfulwebservices.controller;

import com.demo.rest.webservices.restfulwebservices.dao.PostDAO;
import com.demo.rest.webservices.restfulwebservices.dao.UserDAO;
import com.demo.rest.webservices.restfulwebservices.entity.Post;
import com.demo.rest.webservices.restfulwebservices.entity.User;
import com.demo.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PostDAO postDAO;

    @GetMapping(path = "/users/{userId}/posts")
    public List<Post> getPostsForUser(@PathVariable int userId) {
        User user = userDAO.getUser(userId);

        if (user == null) {
            throw new UserNotFoundException("Id : " + userId);
        }

        List<Post> userPostList = postDAO.getPosts(userId);

        return userPostList;
    }

    @PostMapping(path = "/users/{userId}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int userId, @RequestBody Post post) {
        User user = userDAO.getUser(userId);

        if (user == null) {
            throw new UserNotFoundException("Id : " + userId);
        }

        Post createdPost = postDAO.createPost(user,post);

        URI createdUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postId}").buildAndExpand(createdPost.getId()).toUri();

        return ResponseEntity.created(createdUri).build();
    }
}
