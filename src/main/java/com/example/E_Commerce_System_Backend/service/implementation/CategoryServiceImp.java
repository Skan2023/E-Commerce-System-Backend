package com.example.E_Commerce_System_Backend.service.implementation;

import com.example.E_Commerce_System_Backend.model.Category;
import com.example.E_Commerce_System_Backend.model.request.CategoryRequest;
import com.example.E_Commerce_System_Backend.repository.CategoryRepository;
import com.example.E_Commerce_System_Backend.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAllCategories();
    }

    @Override
    public Category getCategoryById(Integer id) {
        Category category = categoryRepository.findCategoryById(id);

        return category;
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        return categoryRepository.createCategory(categoryRequest);
    }

    @Override
    public Category updateCategory(CategoryRequest categoryRequest, Integer id) {
        return null;
    }

    @Override
    public Category deleteCategory(Integer id) {
        return categoryRepository.deleteCategory(id);
    }
}
