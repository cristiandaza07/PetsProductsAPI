package com.petsproducts.product.application.command.delete;

import com.petsproducts.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteProductRequest implements Request<Void> {

    private Long id;

}
