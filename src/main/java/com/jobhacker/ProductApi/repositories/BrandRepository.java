package com.jobhacker.ProductApi.repositories;

import com.jobhacker.ProductApi.models.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {

}
