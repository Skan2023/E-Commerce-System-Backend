package com.example.E_Commerce_System_Backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String role;
}
