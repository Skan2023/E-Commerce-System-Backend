package com.example.E_Commerce_System_Backend.service.implementation;

import com.example.E_Commerce_System_Backend.model.Product;
import com.example.E_Commerce_System_Backend.model.request.ProductRequest;
import com.example.E_Commerce_System_Backend.repository.ProductRepository;
import com.example.E_Commerce_System_Backend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Product deleteProductById(Integer id) {
        return productRepository.deleteProductById(id);
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        return productRepository.addProduct(productRequest);
    }

    @Override
    public Product updateProductById(ProductRequest productRequest, Integer id) {
        Product product = productRepository.updateProductById(productRequest, id);

        if (product == null) {
            return null;
        }

        return product;
    }
}
