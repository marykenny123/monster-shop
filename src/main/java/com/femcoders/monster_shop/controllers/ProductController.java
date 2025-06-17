package com.femcoders.monster_shop.controllers;

import com.femcoders.monster_shop.models.Product;
import com.femcoders.monster_shop.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
        Product createdProduct = productService.addProduct(newProduct);
        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
    }


}
