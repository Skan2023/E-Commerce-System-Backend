package com.example.E_Commerce_System_Backend.repository;

import com.example.E_Commerce_System_Backend.model.User;
import com.example.E_Commerce_System_Backend.model.request.UserRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select("select * from users")
    @Results(id = "userMapper", value = {
            @Result(property = "userId", column = "user_id")
    })
    List<User> findAllUsers();

    @Select("SELECT * FROM users WHERE user_id = #{id}")
    @ResultMap("userMapper")
    User findUserById(@Param("id") Integer id);

    @Select("""
            insert into users(name, email, password, role)
            values (#{user.name}, #{user.email}, #{user.password}, #{user.role})
            returning *
            """)
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @ResultMap("userMapper")
    User insertUser(@Param("user") UserRequest userRequest);

    @Select("""
            UPDATE users SET name=#{user.name}, email=#{user.email}, password=#{user.password}, role=#{user.role} WHERE user_id=#{id}
            returning *;
            """)
    @ResultMap("userMapper")
    User updateUserById(@Param("user") UserRequest userRequest, Integer id);

    @Select("""
            DELETE FROM users WHERE user_id=#{id}
            returing *
            """)
    User deleteUserById(@Param("id") Integer id);
}
