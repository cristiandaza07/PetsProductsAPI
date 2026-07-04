package com.petsproducts.category.infrastructure.api;

import com.petsproducts.category.infrastructure.api.dto.CreateCategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategoryApi {
    ResponseEntity<Void> saveCategory(@RequestBody CreateCategoryDto createCategoryDto);
}
