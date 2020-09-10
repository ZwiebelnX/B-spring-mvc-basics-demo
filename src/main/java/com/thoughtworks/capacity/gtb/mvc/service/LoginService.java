package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.model.exception.LoginRequestException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepo;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class LoginService {

    private final UserRepo userRepo;

    public LoginService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void register(User user) {
        userRepo.save(user);
    }

    public User login(String username, String password) {
        if (!Pattern.matches("(\\w){3,10}", username)) {
            throw new LoginRequestException("用户名长度需要在3-10之间");
        }
        if (!Pattern.matches(".{5,12}", password)) {
            throw new LoginRequestException("密码长度需要在5-12之间");
        }
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new LoginRequestException("用户名不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new LoginRequestException("密码错误");
        }
        return user;
    }
}
