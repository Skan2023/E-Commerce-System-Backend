package com.example.E_Commerce_System_Backend.service;

import com.example.E_Commerce_System_Backend.model.User;
import com.example.E_Commerce_System_Backend.model.request.UserRequest;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User createUser(UserRequest userRequest);
    User updateUser(UserRequest userRequest, Integer id);
    User deleteUserById(Integer id);
}
