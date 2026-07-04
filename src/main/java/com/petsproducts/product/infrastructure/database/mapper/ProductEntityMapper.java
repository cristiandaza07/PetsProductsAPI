package com.petsproducts.product.infrastructure.database.mapper;

import com.petsproducts.category.domain.entity.Category;
import com.petsproducts.category.infrastructure.database.entity.CategoryEntity;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.infrastructure.database.entity.ProductEntity;
import com.petsproducts.review.domain.entity.Review;
import com.petsproducts.review.infrastructure.database.entity.ReviewEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductEntityMapper {

    @Mapping(target = "productDetailEntity", source = "productDetail")
    @Mapping(target = "productDetailEntity.productEntity", ignore = true)
    ProductEntity mapToProductEntity(Product product);

    @Mapping(target = "productDetail", source = "productDetailEntity")
    @Mapping(target = "productDetail.product", ignore = true)
    Product mapToProduct(ProductEntity productEntity);

    @Mapping(target = "product", ignore = true)
    Review mapToReview(ReviewEntity reviewEntity);

    @Mapping(target = "productEntity", ignore = true)
    ReviewEntity mapToReviewEntity(Review review);

    @Mapping(target = "products", ignore = true)
    Category mapToCategory(CategoryEntity categoryEntity);

    @Mapping(target = "products", ignore = true)
    CategoryEntity mapToCategoryEntity(Category category);

    @AfterMapping
    default void linkReviews(@MappingTarget ProductEntity productEntity) {
        if (productEntity.getReviews() != null) {
            productEntity.getReviews().forEach(r -> r.setProductEntity(productEntity));
        }
    }

}
