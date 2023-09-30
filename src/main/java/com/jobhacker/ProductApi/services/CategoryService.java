package com.jobhacker.ProductApi.services;

import com.jobhacker.ProductApi.models.dtos.CategoryDto;
import com.jobhacker.ProductApi.models.entities.Category;
import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();

    CategoryDto getCategoriesByID(long id);

    CategoryDto addCategory(Category category);

    CategoryDto updateCategory(Category category);

    void deleteCategory(long id);
}
