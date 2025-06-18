package com.femcoders.monster_shop.repositories;


import com.femcoders.monster_shop.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProductId(Long productId);
}


