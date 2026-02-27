package com.example.E_Commerce_System_Backend.repository;

import com.example.E_Commerce_System_Backend.model.Product;
import com.example.E_Commerce_System_Backend.model.request.ProductRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {

    @Select("select * from products")
    @Results(id = "productMapper", value = {
            @Result(property = "productId", column = "product_id"),
            @Result(property = "categoryId", column = "category_id",
                one = @One(select = "com.example.E_Commerce_System_Backend.repository.CategoryRepository.findCategoryById")
            )
    })
    List<Product> findAllProducts();

    @Select("select * from products WHERE product_id = #{id}")
    @ResultMap("productMapper")
    Product findProductById(Integer id);

    @Select("""
            delete from products WHERE product_id = #{id}
            returning *
            """)
    Product deleteProductById(Integer id);

    @Select("""
            insert into products(name, price, stock, category_id)
            values (#{product.name}, #{product.price}, #{product.stock}, #{product.categoryId})
            returning *
            """)
    @Options(useGeneratedKeys = true, keyProperty = "productId")
    @ResultMap("productMapper")
    Product addProduct(@Param("product") ProductRequest productRequest);

    @Select("""
            UPDATE products SET name=#{product.name}, price=#{product.price}, stock=#{product.stock}, category_id=#{product.categoryId} WHERE product_id=#{id}
            returning *;
            """)
    @ResultMap("productMapper")
    Product updateProductById(@Param("product") ProductRequest productRequest, Integer id);
}
