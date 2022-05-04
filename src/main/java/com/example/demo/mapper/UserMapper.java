package com.example.demo.mapper;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select(value = "select * from users where user_name=#{user_name} and password = #{password}")
    User selectOneUser(User user);

    @Select(value = "select * from users where user_name=#{user_name}")
    User checkUser(UserRegisterDto user);

    @Insert(value = "insert into users (user_name,password,phone,is_deleted) values (#{user_name},#{password},#{phone},#{is_deleted})")
    void insertUser(User user);

    @Select("select * from users")
    List<User> findAll();

    @Update(value="update users set user_name=#{user_name},password=#{password},phone=#{phone} where id =#{id}")
    void updateUser();
}
