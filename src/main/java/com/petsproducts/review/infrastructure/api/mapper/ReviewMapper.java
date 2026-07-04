package com.petsproducts.review.infrastructure.api.mapper;


import com.petsproducts.review.application.command.CreateReviewRequest;
import com.petsproducts.review.infrastructure.api.dto.CreateReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ReviewMapper {
    CreateReviewRequest mapToCreateReviewRequest(CreateReviewDto createReviewDto, Long productId);

}
