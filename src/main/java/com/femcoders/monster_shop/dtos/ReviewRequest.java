package com.femcoders.monster_shop.dtos;

public record ReviewRequest(Long productId, String username, double rating, String body) {
}
