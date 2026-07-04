package com.petsproducts.product.application.command.create;

import com.petsproducts.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Data
public class CreateProductRequest implements Request<CreateProductResponse> {

    private String name;
    private String description;
    private Double price;
    private MultipartFile file;
    private String targetSpecies;
    private String lifeStage;
    private String brand;
}
