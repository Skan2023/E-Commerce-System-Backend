package com.example.E_Commerce_System_Backend.controller;

import com.example.E_Commerce_System_Backend.model.User;
import com.example.E_Commerce_System_Backend.model.request.UserRequest;
import com.example.E_Commerce_System_Backend.model.response.ApiResponse;
import com.example.E_Commerce_System_Backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        ApiResponse<List<User>> response = ApiResponse.<List<User>>builder()
                .message("Users fetched successfully.")
                .payload(users)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);

        if (user != null) {
            ApiResponse<User> response = ApiResponse.<User>builder()
                    .message("User fetched successfully.")
                    .payload(user)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        ApiResponse<User> response = ApiResponse.<User>builder()
                .message("User with id " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);

        ApiResponse<User> response = ApiResponse.<User>builder()
                .message("User created successfully.")
                .payload(user)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUserById(@RequestBody UserRequest userRequest, @PathVariable Integer id) {
        User user = userService.updateUser(userRequest, id);

        ApiResponse<User> response = ApiResponse.<User>builder()
                .message("User updated successfully.")
                .payload(user)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> deleteUser(@PathVariable Integer id) {
        User user = userService.deleteUserById(id);

        if (user != null) {
            ApiResponse<User> response = ApiResponse.<User>builder()
                    .message("User deleted successfully.")
                    .payload(null)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        ApiResponse<User> response = ApiResponse.<User>builder()
                .message("User with id " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
