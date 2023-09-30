package com.jobhacker.ProductApi.mappers;

import com.jobhacker.ProductApi.models.dtos.ProductDto;
import com.jobhacker.ProductApi.models.entities.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {
   /* @Mapping(source = "category.id",target = "categoryId")
    @Mapping(source = "brand.id",target = "brandId")*/
    ProductDto mapToDto(Product product);
    Product mapToEntity(ProductDto productDto);
}
