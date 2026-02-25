package com.example.E_Commerce_System_Backend.service;

import com.example.E_Commerce_System_Backend.model.Category;
import com.example.E_Commerce_System_Backend.model.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Integer id);
    Category createCategory(CategoryRequest categoryRequest);
    Category updateCategory(CategoryRequest categoryRequest, Integer id);
    Category deleteCategory(Integer id);
}
