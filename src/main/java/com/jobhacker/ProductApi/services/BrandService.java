package com.jobhacker.ProductApi.services;

import com.jobhacker.ProductApi.models.dtos.BrandDto;
import com.jobhacker.ProductApi.models.entities.Brand;
import java.util.List;

public interface BrandService {
    List<BrandDto> getBrands();

    BrandDto getBrandsByID(long id);

    BrandDto addBrand(Brand brand);

    BrandDto updateBrand(Brand brand);

    void deleteBrand(long id);
}
