package com.jobhacker.ProductApi.repositories;

import com.jobhacker.ProductApi.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Category,Long> {

}
