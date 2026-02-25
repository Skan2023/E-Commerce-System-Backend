package com.example.E_Commerce_System_Backend.controller;

import com.example.E_Commerce_System_Backend.model.Category;
import com.example.E_Commerce_System_Backend.model.request.CategoryRequest;
import com.example.E_Commerce_System_Backend.model.response.ApiResponse;
import com.example.E_Commerce_System_Backend.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();

        ApiResponse<List<Category>> response = ApiResponse.<List<Category>>builder()
                .message("Categories fetched successfully.")
                .payload(categories)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> getCategoryById(@PathVariable Integer id) {
        Category category = categoryService.getCategoryById(id);

        if (category != null) {
            ApiResponse<Category> response = ApiResponse.<Category>builder()
                    .message("Category with " + id + " fetched successfully.")
                    .payload(category)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Category with " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> createCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryService.createCategory(categoryRequest);

        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Category created successfully.")
                .payload(category)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> updateCategory(@RequestBody CategoryRequest categoryRequest, Integer id) {
        Category category = categoryService.updateCategory(categoryRequest, id);

        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Category updated successfully.")
                .payload(category)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> deleteCategoryById(@PathVariable Integer id) {
        Category category = categoryService.deleteCategory(id);

        if (category != null) {
            ApiResponse<Category> response = ApiResponse.<Category>builder()
                    .message("Category with id " + id + " deleted successfully.")
                    .payload(null)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Category with id " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
