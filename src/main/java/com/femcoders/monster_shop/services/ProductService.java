package com.femcoders.monster_shop.services;

import com.femcoders.monster_shop.models.Product;
import com.femcoders.monster_shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);

    }

}
