package com.jobhacker.ProductApi.services;

import com.jobhacker.ProductApi.mappers.CategoryMapper;
import com.jobhacker.ProductApi.models.dtos.CategoryDto;
import com.jobhacker.ProductApi.models.entities.Category;
import com.jobhacker.ProductApi.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoriesRepository categoriesRepository;
    private final CategoryMapper categoryMapper;
    @Autowired
    public CategoryServiceImpl(CategoriesRepository categoriesRepository, CategoryMapper categoryMapper) {
        this.categoriesRepository = categoriesRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getCategories(){
        List<Category> categories=categoriesRepository.findAll();
        return categories.stream()
                .map(categoryMapper::mapToDto)
                .toList();
    }
    @Override
    public CategoryDto getCategoriesByID(long id){
        return  categoriesRepository.findById(id)
                .map(categoryMapper::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND
                ,"Category Not Fond"));

    }
    @Override
    public CategoryDto addCategory(Category categoriesEntity){
        Category category=categoriesRepository.save(categoriesEntity);
        return categoryMapper.mapToDto(category);
    }
    @Override
    public CategoryDto updateCategory(Category categories) {
        Optional<Category> catOptional = categoriesRepository.findById((long) categories.getId());

        if (catOptional.isPresent()) {
            Category categoriesEntity = catOptional.get();
            categoriesEntity.setName(categories.getName());
            categoriesEntity.setDescription(categories.getDescription());
            Category category=categoriesRepository.save(categoriesEntity);
            return categoryMapper.mapToDto(category);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }
    @Override
    public void deleteCategory(long id) {
        Category category = categoriesRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        categoriesRepository.delete(category);
    }
}
