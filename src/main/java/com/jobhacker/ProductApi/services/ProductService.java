package com.jobhacker.ProductApi.services;

import com.jobhacker.ProductApi.models.dtos.ProductDto;
import com.jobhacker.ProductApi.models.entities.Product;
import java.util.List;

public interface ProductService {

    List<ProductDto> getProducts();
    ProductDto getProductByID(long id);

    List<ProductDto> getProductsByCategoryId(int categoryId);

    List<ProductDto> getProductsByBrandId(int brandId);

    ProductDto addProduct(Product product);

    ProductDto updateProduct(Product product);

    double getPriceByProductId(long productId);

    void deleteProduct(long id);
}
