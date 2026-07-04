package com.petsproducts.product.application.command.assignCategory;

import com.petsproducts.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AssignCategoryRequest implements Request<Void> {
    private String categoryName;
    private Long productId;
}
