package com.petsproducts.review.application.command;

import com.petsproducts.review.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateReviewResponse {
    private Review review;
}
