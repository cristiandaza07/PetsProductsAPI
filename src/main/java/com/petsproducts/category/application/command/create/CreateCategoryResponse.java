package com.petsproducts.category.application.command.create;

import com.petsproducts.category.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateCategoryResponse {
    private Category category;
}
