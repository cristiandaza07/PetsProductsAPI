package com.petsproducts.review.application.command;

import com.petsproducts.common.application.mediator.RequestHandler;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.domain.port.ProductRepository;
import com.petsproducts.review.domain.entity.Review;
import com.petsproducts.review.domain.port.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class CreateReviewHandler implements RequestHandler<CreateReviewRequest, CreateReviewResponse> {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    @Override
    public CreateReviewResponse handle(CreateReviewRequest request) {

        Product product = productRepository.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));

        Review review = Review.builder()
                .comment(request.getComment())
                .score(request.getScore())
                .product(product)
                .build();

        Review storedReview = reviewRepository.save(review);
        log.info("Created review with id: {}", storedReview.getId());

        product.getReviews().add(storedReview);

        return new CreateReviewResponse(storedReview);
    }

    @Override
    public Class<CreateReviewRequest> getRequestType() {
        return CreateReviewRequest.class;
    }
}
