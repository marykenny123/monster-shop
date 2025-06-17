package com.femcoders.monster_shop.controllers;

import com.femcoders.monster_shop.models.Product;
import com.femcoders.monster_shop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

//    @PostMapping("/api/products")
//    public void addProduct(@RequestBody Product newProduct){
//        productService.addProduct(newProduct);
//    }


}
