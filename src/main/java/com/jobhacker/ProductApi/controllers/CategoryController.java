package com.jobhacker.ProductApi.controllers;

import com.jobhacker.ProductApi.models.dtos.CategoryDto;
import com.jobhacker.ProductApi.models.entities.Category;
import com.jobhacker.ProductApi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categoriesEntityList = categoryService.getCategories();
        return new ResponseEntity<>(categoriesEntityList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoriesByID(@PathVariable int id) {
        CategoryDto result = categoryService.getCategoriesByID(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@RequestBody Category categoriesEntity) {
        CategoryDto result = categoryService.addCategory(categoriesEntity);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody Category categories) {
        CategoryDto category = categoryService.updateCategory(categories);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted Successfully");
    }
}
