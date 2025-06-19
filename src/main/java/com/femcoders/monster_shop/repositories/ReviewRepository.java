package com.femcoders.monster_shop.repositories;


import com.femcoders.monster_shop.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    <List<Review> findAllByProductId(Long productId);
}


