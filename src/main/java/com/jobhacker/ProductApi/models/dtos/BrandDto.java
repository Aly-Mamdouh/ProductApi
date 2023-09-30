package com.jobhacker.ProductApi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {
    private int id;
    private String name;
    private String description;
}
