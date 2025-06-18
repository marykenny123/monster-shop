package com.femcoders.monster_shop.services;

import com.femcoders.monster_shop.models.Product;
import com.femcoders.monster_shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct;
    }

    public boolean updateProduct (Long id, Product productToUpdate) {
        Optional<Product> productDetails= productRepository.findById(id);
        if (productDetails.isPresent()) {
            Product newProductDetails = productDetails.get();
            newProductDetails.setName(productToUpdate.getName());
            newProductDetails.setPrice(productToUpdate.getPrice());
            newProductDetails.setImageUrl(productToUpdate.getImageUrl());
            newProductDetails.setRating(productToUpdate.getRating());
            newProductDetails.setReviewCount(productToUpdate.getReviewCount());
            newProductDetails.setFeatured(productToUpdate.isFeatured());
            productRepository.save(newProductDetails);
            return true;
        }
        return false;
    }

    public boolean deleteProduct (Long id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }


}
