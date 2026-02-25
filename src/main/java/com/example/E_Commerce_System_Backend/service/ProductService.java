package com.example.E_Commerce_System_Backend.service;

import com.example.E_Commerce_System_Backend.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    Product deleteProductById(Integer id);
}
