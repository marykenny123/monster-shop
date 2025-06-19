package com.femcoders.monster_shop.dtos;

import com.femcoders.monster_shop.models.Review;

public class ReviewMapper {

    public static Review dtoToEntity(ReviewRequest reviewRequest) {
        return new Review(reviewRequest.username(), reviewRequest.rating(), reviewRequest.body());
    }
}
