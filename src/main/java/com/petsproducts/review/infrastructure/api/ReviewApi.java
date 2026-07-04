package com.petsproducts.review.infrastructure.api;

import com.petsproducts.review.infrastructure.api.dto.CreateReviewDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ReviewApi {
    ResponseEntity<Void> saveReview(@PathVariable Long productId, @RequestBody CreateReviewDto createReviewDto);
}
