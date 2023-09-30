package com.jobhacker.ProductApi.mappers;

import com.jobhacker.ProductApi.models.dtos.BrandDto;
import com.jobhacker.ProductApi.models.entities.Brand;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-13T15:52:35+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public BrandDto mapToDto(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandDto brandDto = new BrandDto();

        brandDto.setId( brand.getId() );
        brandDto.setName( brand.getName() );
        brandDto.setDescription( brand.getDescription() );

        return brandDto;
    }

    @Override
    public Brand mapToEntity(BrandDto brandDto) {
        if ( brandDto == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( brandDto.getId() );
        brand.setName( brandDto.getName() );
        brand.setDescription( brandDto.getDescription() );

        return brand;
    }
}
