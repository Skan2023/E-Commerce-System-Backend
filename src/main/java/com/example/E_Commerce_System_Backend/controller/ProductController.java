package com.example.E_Commerce_System_Backend.controller;

import com.example.E_Commerce_System_Backend.model.Product;
import com.example.E_Commerce_System_Backend.model.response.ApiResponse;
import com.example.E_Commerce_System_Backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        ApiResponse<List<Product>> response = ApiResponse.<List<Product>>builder()
                .message("Product fetched successfully.")
                .payload(products)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);

        if (product != null) {
            ApiResponse<Product> response = ApiResponse.<Product>builder()
                    .message("Product with id " + id + " fetched successfully.")
                    .payload(product)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
          ApiResponse<Product> response = ApiResponse.<Product>builder()
                  .message("Product with id " + id + " not found.")
                  .payload(null)
                  .status(HttpStatus.NOT_FOUND)
                  .timestamp(LocalDateTime.now())
                  .build();

          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
