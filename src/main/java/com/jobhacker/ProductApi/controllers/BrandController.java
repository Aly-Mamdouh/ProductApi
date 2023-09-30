package com.jobhacker.ProductApi.controllers;

import com.jobhacker.ProductApi.models.dtos.BrandDto;
import com.jobhacker.ProductApi.models.entities.Brand;
import com.jobhacker.ProductApi.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {
    private final BrandService brandService;
    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getBrands() {
        List<BrandDto>  brandsEntityList= brandService.getBrands();
        return new ResponseEntity<>(brandsEntityList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrandByID(@PathVariable int id) {
        BrandDto result = brandService.getBrandsByID(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<BrandDto> addCategory(@RequestBody Brand brandsEntity) {
        BrandDto result = brandService.addBrand(brandsEntity);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<BrandDto> updateBrand(@RequestBody Brand brands) {
        BrandDto entity= brandService.updateBrand(brands);
        return new ResponseEntity<>(entity,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable long id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok("Brand deleted Successfully");
    }
}
