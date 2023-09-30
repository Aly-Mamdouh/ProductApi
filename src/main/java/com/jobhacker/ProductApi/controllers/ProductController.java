package com.jobhacker.ProductApi.controllers;

import com.jobhacker.ProductApi.models.dtos.ProductDto;
import com.jobhacker.ProductApi.models.entities.Product;
import com.jobhacker.ProductApi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductByID(@PathVariable long id) {
        ProductDto dto = productService.getProductByID(id);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryID(@PathVariable int categoryId) {
        List<ProductDto> dtos = productService.getProductsByCategoryId(categoryId);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<ProductDto>> getProductsByBrandID(@PathVariable int brandId) {
        List<ProductDto> dtos = productService.getProductsByBrandId(brandId);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody Product productsEntity) {
        ProductDto dto = productService.addProduct(productsEntity);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody Product product) {
        ProductDto dto = productService.updateProduct(product);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/price/{productId}")
    public ResponseEntity<Double> getPriceByProductId(@PathVariable int productId) {
        return ResponseEntity.ok(productService.getPriceByProductId(productId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted Successfully");
    }
}
