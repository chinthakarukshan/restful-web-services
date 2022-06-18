package com.demo.rest.webservices.restfulwebservices.dao;

import com.demo.rest.webservices.restfulwebservices.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserDAO {
    private static List<User> users = new ArrayList<>();

    private static AtomicInteger userId = new AtomicInteger(3);

    static {
        users.add(new User(1, "Tesandu", new Date()));
        users.add(new User(2, "Nuhan", new Date()));
        users.add(new User(3, "Kanchana", new Date()));
    }

    public List<User> getUsers() {
        return users;
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(userId.incrementAndGet());
        }
        users.add(user);

        return user;
    }

    public User getUser (int userId) {
        for (User user: users) {
            if (user.getId() == userId) {
                return user;
            }
        }

        return null;
    }

    public User deleteUserById(int userId) {
        Iterator<User> userIterator = users.iterator();

        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getId() == userId) {
                userIterator.remove();
                return user;
            }
        }

        return null;
    }
}
