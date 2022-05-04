package com.example.demo.service;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    User selectUser(User user);
    void saveUser(User user);
    List<User> findAll();
    User checkUser(UserRegisterDto userRegisterDto);
}
