package com.example.E_Commerce_System_Backend.repository;

import com.example.E_Commerce_System_Backend.model.Category;
import com.example.E_Commerce_System_Backend.model.request.CategoryRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepository {

    @Select("select * from categories")
    @Results(id = "categoryMapper", value = {
            @Result(property = "categoryId", column = "category_id")
    })
    List<Category> findAllCategories();

    @Select("select * from categories WHERE category_id=#{id}")
    @ResultMap("categoryMapper")
    Category findCategoryById(Integer id);

    @Select("""
            insert into categories(name)
            values (#{category.name})
            returning *
            """)
    @ResultMap("categoryMapper")
    Category createCategory(@Param("category") CategoryRequest categoryRequest);

    @Select("""
            delete from categories WHERE category_id = #{id}
            returning *
            """)
    @ResultMap("categoryMapper")
    Category deleteCategory(Integer id);
}

