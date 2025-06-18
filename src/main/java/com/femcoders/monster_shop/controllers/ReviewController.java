package com.femcoders.monster_shop.controllers;

import com.femcoders.monster_shop.models.Review;
import com.femcoders.monster_shop.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/api/reviews")
    public ResponseEntity<Review> addReview(@RequestBody Review newReview) {
        Review createdReview = reviewService.addReview(newReview);
        return new ResponseEntity<Review>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/api/reviews/{productId}")
    public ResponseEntity<List<Review>> showReviewsByProductId(@PathVariable Long productId) {
        boolean reviewExists = reviewService.showReviewsByProductId(productId);
        if (!reviewExists) {
            return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
