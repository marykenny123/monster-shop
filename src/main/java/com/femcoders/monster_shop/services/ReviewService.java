package com.femcoders.monster_shop.services;


import com.femcoders.monster_shop.models.Product;
import com.femcoders.monster_shop.models.Review;
import com.femcoders.monster_shop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Review newReview) {
        return reviewRepository.save(newReview);
    }

    public boolean showReviewsByProductId(Long productId) {/        List <Review> reviews = reviewRepository.findByProductId(productId);
        boolean reviewExists;
        if (!reviews.isEmpty()) {
            return reviewExists = false;
        }
        return true;
    }

    // test

    public Optional <List<Review>> getReviewsByProductId(Long productId) {
        System.out.println("inside service before asignation");
        Optional<List<Review>> optionalReview = reviewRepository.findByProductId(productId);
        System.out.println("inside service after asignation before return");
        return optionalReview;
    }

}
