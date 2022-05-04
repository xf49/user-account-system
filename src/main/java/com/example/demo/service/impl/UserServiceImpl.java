package com.example.demo.service.impl;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user){
        user.setIs_deleted(0);
        userMapper.insertUser(user);
    }

    public User checkUser(UserRegisterDto userRegisterDto){
        return userMapper.checkUser(userRegisterDto);
    }

    @Override
    public User selectUser(User user){
        if(user.getUser_name()==null||user.getPassword()==null){
            return null;
        }
        return userMapper.selectOneUser(user);
    }

    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

}
