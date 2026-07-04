package com.petsproducts.category.application.command.create;

import com.petsproducts.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateCategoryRequest implements Request<CreateCategoryResponse> {
    private String name;
}
