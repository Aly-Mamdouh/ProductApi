package com.jobhacker.ProductApi.services;

import com.jobhacker.ProductApi.mappers.ProductMapper;
import com.jobhacker.ProductApi.models.dtos.ProductDto;
import com.jobhacker.ProductApi.models.entities.Product;
import com.jobhacker.ProductApi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private static final String MESSAGE = "Product not found";

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    @Override
    public ProductDto getProductByID(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MESSAGE));
        return productMapper.mapToDto(product);
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(int categoryId) {
        List<Product> products = productRepository.getProductsByCategoryId(categoryId);
        return products.stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    @Override
    public List<ProductDto> getProductsByBrandId(int brandId) {
        List<Product> products = productRepository.getProductsByBrandId(brandId);
        return products.stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    @Override
    public ProductDto addProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(Product product) {
        Optional<Product> productOptional = productRepository.findById((long) product.getId());

        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setBrand(product.getBrand());
            Product updatedProduct = productRepository.save(existingProduct);
            return productMapper.mapToDto(updatedProduct);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MESSAGE);
        }
    }

    @Override
    public double getPriceByProductId(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MESSAGE));

        return product.getPrice();
    }

    @Override
    public void deleteProduct(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MESSAGE));
        productRepository.delete(product);
    }
}
