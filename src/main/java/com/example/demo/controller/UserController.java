package com.example.demo.controller;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserRegisterDto userRegisterDto){
        if(userRegisterDto==null){
            return "sorry. username,password and phone are required,please try again";
        }
        if(userRegisterDto.getUser_name().isEmpty()||userRegisterDto.getPassword().isEmpty()||userRegisterDto.getPhone().isEmpty()){
            return "sorry. username,password and phone are required,please try again";
        }

        if(userService.checkUser(userRegisterDto)!=null){
            return "this user name has been register,please try others";
        }
        User user = new User();
        user.setUser_name(userRegisterDto.getUser_name());
        user.setPassword(userRegisterDto.getPassword());
        user.setPhone(userRegisterDto.getPhone());

        userService.saveUser(user);
        return "you have sucessfully registered ";
    }

    @PostMapping("/login")
    public String loginIn(@RequestBody UserLoginDto userLoginDto){
        HashMap<String,String> response = new HashMap();
        if(userLoginDto==null){
            return "log in failed";
        }
        User user=new User();
        user.setUser_name(userLoginDto.getUser_name());
        user.setPassword(userLoginDto.getPassword());
        if(userService.selectUser(user)==null){
            return "Incorrect username or password,please try again";
        }
        String token = Utils.genarateToken();
        return token;
    }
}
