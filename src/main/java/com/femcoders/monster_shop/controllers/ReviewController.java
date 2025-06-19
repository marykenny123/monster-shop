package com.femcoders.monster_shop.controllers;

import com.femcoders.monster_shop.dtos.ReviewRequest;
import com.femcoders.monster_shop.models.Review;
import com.femcoders.monster_shop.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/api/reviews")
    public ResponseEntity<Review> addReview(@RequestBody ReviewRequest newReview) {
        Review createdReview = reviewService.addReview(newReview);
        return new ResponseEntity<Review>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/api/reviews/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        System.out.println("Product ID received from postman: " + productId);
        System.out.println("in controller after if not fulfilled just before return outside if, should print when optional has reviews");
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

}
