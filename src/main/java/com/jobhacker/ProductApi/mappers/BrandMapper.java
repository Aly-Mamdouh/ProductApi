package com.jobhacker.ProductApi.mappers;

import com.jobhacker.ProductApi.models.dtos.BrandDto;
import com.jobhacker.ProductApi.models.entities.Brand;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BrandMapper {
    BrandDto mapToDto(Brand brand);
    Brand mapToEntity(BrandDto brandDto);
}
