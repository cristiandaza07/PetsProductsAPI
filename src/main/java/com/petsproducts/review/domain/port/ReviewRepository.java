package com.petsproducts.review.domain.port;

import com.petsproducts.review.domain.entity.Review;

public interface ReviewRepository {
    Review save(Review review);

}
