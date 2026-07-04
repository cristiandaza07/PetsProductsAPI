package com.petsproducts.product.infrastructure.api.mapper;

import com.petsproducts.category.domain.entity.Category;
import com.petsproducts.product.application.command.assignCategory.AssignCategoryRequest;
import com.petsproducts.product.application.command.create.CreateProductRequest;
import com.petsproducts.product.application.command.update.UpdateProductRequest;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.infrastructure.api.dto.CreateProductDto;
import com.petsproducts.product.infrastructure.api.dto.ProductDto;
import com.petsproducts.product.infrastructure.api.dto.ReviewDto;
import com.petsproducts.product.infrastructure.api.dto.UpdateProductDto;
import com.petsproducts.review.domain.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {
    CreateProductRequest mapToCreateProductRequest(CreateProductDto createProductDto);

    UpdateProductRequest mapToUpdateProductRequest(UpdateProductDto updateProductDto);

    @Mapping(target = "targetSpecies", source = "product.productDetail.targetSpecies")
    @Mapping(target = "lifeStage", source = "product.productDetail.lifeStage")
    @Mapping(target = "brand", source = "product.productDetail.brand")
    ProductDto mapToProductDto(Product product);

    @Mapping(target = "product", ignore = true)
    Review mapToReview(ReviewDto reviewDto);

    default List<String> mapToCategoryNames(List<Category> categories) {
        return categories.stream().map(Category::getName).toList();
    }

    AssignCategoryRequest mapToAssignCategoryRequest(String categoryName, Long productId);

}
