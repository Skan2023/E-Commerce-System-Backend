package com.example.E_Commerce_System_Backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer productId;
    private String name;
    private Double price;
    private Integer stock;
    private Integer categoryId;
}
