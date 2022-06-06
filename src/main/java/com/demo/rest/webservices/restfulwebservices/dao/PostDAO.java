package com.demo.rest.webservices.restfulwebservices.dao;

import com.demo.rest.webservices.restfulwebservices.entity.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO {
    private static List<Post> userPosts;

    public List<Post> getPosts(int userId) {
        List<Post> userPostList = new ArrayList<>();

        for (Post post: userPosts) {
            if (post.getUser().getId() == userId) {
                userPostList.add(post);
            }
        }

        return userPosts;
    }
}
