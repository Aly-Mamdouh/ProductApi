package com.jobhacker.ProductApi.services;

import com.jobhacker.ProductApi.mappers.BrandMapper;
import com.jobhacker.ProductApi.models.dtos.BrandDto;
import com.jobhacker.ProductApi.models.entities.Brand;
import com.jobhacker.ProductApi.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;
    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public List<BrandDto> getBrands(){
        List<Brand> brands=brandRepository.findAll();
        return brands.stream()
                .map(brandMapper::mapToDto)
                .toList();
    }
    @Override
    public BrandDto getBrandsByID(long id){
        return brandRepository.findById( id)
                .map(brandMapper::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Brand Not Found"));
    }
    @Override
    public BrandDto addBrand(Brand brandsEntity){
        return brandMapper.mapToDto(brandRepository.save(brandsEntity));
    }
    @Override
    public BrandDto updateBrand(Brand categories) {
        Optional<Brand> catOptional = brandRepository.findById((long) categories.getId());

        if (catOptional.isPresent()) {
            Brand brandsEntity = catOptional.get();
            brandsEntity.setName(categories.getName());
            brandsEntity.setDescription(categories.getDescription());

            return brandMapper.mapToDto(brandRepository.save(brandsEntity));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Brand not found");
        }
    }
    @Override
    public void deleteBrand(long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));
        brandRepository.delete(brand);
    }
}
