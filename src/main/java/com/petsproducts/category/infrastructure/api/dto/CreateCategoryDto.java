package com.petsproducts.category.infrastructure.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCategoryDto {
    @NotBlank
    private String name;
}
