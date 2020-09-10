package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.model.exception.UserConflictException;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserRepo {

    private final static Set<User> userSet = Collections.synchronizedSet(new HashSet<>());

    public void save(User user) {
        if (!userSet.contains(user)) {
            userSet.add(user);
        } else {
            throw new UserConflictException(user.getUsername());
        }
    }
}
