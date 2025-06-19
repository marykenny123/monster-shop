package com.femcoders.monster_shop.services;


import com.femcoders.monster_shop.dtos.ReviewRequest;
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

    public Review addReview(ReviewRequest newReview) {
        Long productId = newReview.productId();
        // usar func findbyid de product con este id productId
        // convertir dto a entidad usando funcion que hemos hecho en mapper (llamar mapper.funccion) para cambiar tipo entidad ahora en formato dto, recoger en variable tipo Review y usar este variable para el siguiente paso
        // añadir este producto al review que se va a crear

        return reviewRepository.save(newReview);
    }

    public List<Review> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findAllByProductId(productId);
        System.out.println("Pulled from repo: " + reviews.size()); // test
        return reviews;
    }

}
