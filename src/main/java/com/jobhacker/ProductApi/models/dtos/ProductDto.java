package com.jobhacker.ProductApi.models.dtos;

import com.jobhacker.ProductApi.models.entities.Brand;
import com.jobhacker.ProductApi.models.entities.Category;
import lombok.Data;


@Data
public class ProductDto {
    private int id;
    private String name;
    private Double price;
    private Boolean isDeleted;
    private Category category;
    private Brand brand;
}
