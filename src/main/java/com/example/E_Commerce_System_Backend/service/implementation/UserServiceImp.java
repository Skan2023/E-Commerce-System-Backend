package com.example.E_Commerce_System_Backend.service.implementation;

import com.example.E_Commerce_System_Backend.model.User;
import com.example.E_Commerce_System_Backend.model.request.UserRequest;
import com.example.E_Commerce_System_Backend.repository.UserRepository;
import com.example.E_Commerce_System_Backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User createUser(UserRequest userRequest) {
        return userRepository.insertUser(userRequest);
    }

    @Override
    public User updateUser(UserRequest userRequest, Integer id) {
        return userRepository.updateUserById(userRequest, id);
    }

    @Override
    public User deleteUserById(Integer id) {
        return userRepository.deleteUserById(id);
    }
}
