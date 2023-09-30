package com.jobhacker.ProductApi.mappers;

import com.jobhacker.ProductApi.models.dtos.CategoryDto;
import com.jobhacker.ProductApi.models.entities.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper {
    CategoryDto mapToDto(Category category);
    Category mapToEntity(CategoryDto categoryDto);
}
