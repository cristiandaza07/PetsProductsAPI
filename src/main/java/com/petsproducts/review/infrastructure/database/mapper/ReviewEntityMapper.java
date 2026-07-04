package com.petsproducts.review.infrastructure.database.mapper;

import com.petsproducts.review.domain.entity.Review;
import com.petsproducts.review.infrastructure.database.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ReviewEntityMapper {
    @Mapping(source = "product", target = "productEntity")
    @Mapping(target = "productEntity.productDetailEntity", ignore = true)
    @Mapping(target = "productEntity.reviews", ignore = true)
    ReviewEntity mapToReviewEntity(Review review);

    @Mapping(source = "productEntity", target = "product")
    @Mapping(target = "product.productDetail", ignore = true)
    @Mapping(target = "product.reviews", ignore = true)
    Review mapToReview(ReviewEntity reviewEntity);
}
