package com.jobhacker.ProductApi.mappers;

import com.jobhacker.ProductApi.models.dtos.ProductDto;
import com.jobhacker.ProductApi.models.entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-13T15:52:35+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto mapToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );
        productDto.setIsDeleted( product.getIsDeleted() );
        productDto.setCategory( product.getCategory() );
        productDto.setBrand( product.getBrand() );

        return productDto;
    }

    @Override
    public Product mapToEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setPrice( productDto.getPrice() );
        product.setIsDeleted( productDto.getIsDeleted() );
        product.setCategory( productDto.getCategory() );
        product.setBrand( productDto.getBrand() );

        return product;
    }
}
