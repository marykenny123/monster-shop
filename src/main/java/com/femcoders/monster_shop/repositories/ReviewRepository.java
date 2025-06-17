package com.femcoders.monster_shop.repositories;

import com.femcoders.monster_shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Product, Long> {
}
