package com.demo.rest.webservices.restfulwebservices.dao;

import com.demo.rest.webservices.restfulwebservices.entity.Post;
import com.demo.rest.webservices.restfulwebservices.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PostDAO {
    private static List<Post> userPosts = new ArrayList<>();

    private static AtomicInteger postId = new AtomicInteger(1);

    public List<Post> getPosts(int userId) {
        List<Post> userPostList = new ArrayList<>();

        for (Post post: userPosts) {
            if (post.getUser().getId() == userId) {
                userPostList.add(post);
            }
        }

        return userPosts;
    }

    public Post createPost(User user, Post post) {
        post.setId(postId.incrementAndGet());
        post.setUser(user);
        userPosts.add(post);

        return post;
    }
}
