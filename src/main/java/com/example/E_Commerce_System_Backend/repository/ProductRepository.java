package com.example.E_Commerce_System_Backend.repository;

import com.example.E_Commerce_System_Backend.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {

    @Select("select * from products")
    @Results(id = "productMapper", value = {
            @Result(property = "productId", column = "product_id")
    })
    List<Product> findAllProducts();

    @Select("select * from products WHERE product_id = #{id}")
    @ResultMap("productMapper")
    Product findProductById(Integer id);
}
