package com.jobhacker.ProductApi.repositories;

import com.jobhacker.ProductApi.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> getProductsByCategoryId(long categoryId);
    List<Product> getProductsByBrandId(long brandId);

}
