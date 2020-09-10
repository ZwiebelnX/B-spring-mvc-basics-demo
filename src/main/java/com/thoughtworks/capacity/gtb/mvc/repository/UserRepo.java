package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.model.exception.UserConflictException;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserRepo {

    private final static Map<String, User> userMap = new ConcurrentHashMap<>();

    private final static AtomicInteger nextId = new AtomicInteger(1);

    public void save(User user) {
        if (!userMap.containsKey(user.getUsername())) {
            user.setId(nextId.get());
            userMap.put(user.getUsername(), user);
            nextId.set(nextId.get() + 1);
        } else {
            throw new UserConflictException(user.getUsername());
        }
    }

    public User findByUsername(String username) {
        return userMap.get(username);
    }
}
