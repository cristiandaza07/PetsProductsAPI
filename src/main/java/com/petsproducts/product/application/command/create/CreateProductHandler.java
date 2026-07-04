package com.petsproducts.product.application.command.create;

import com.petsproducts.common.application.mediator.RequestHandler;
import com.petsproducts.common.infrastructure.util.FileUtils;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.domain.exception.InvalidLifeStageException;
import com.petsproducts.product.domain.exception.InvalidSpeciesException;
import com.petsproducts.product.domain.port.ProductRepository;
import com.petsproducts.productDetail.domian.LifeStage;
import com.petsproducts.productDetail.domian.ProductDetail;
import com.petsproducts.productDetail.domian.TargetSpecies;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class CreateProductHandler implements RequestHandler<CreateProductRequest, CreateProductResponse> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;

    @Override
    public CreateProductResponse handle(CreateProductRequest request) {

        String formattedTargetSpecies = request.getTargetSpecies().toUpperCase().trim();
        String formattedLifeStage = request.getLifeStage().toUpperCase().trim();

        if (!formattedTargetSpecies.equals("DOG") && !formattedTargetSpecies.equals("CAT")) {
            throw new InvalidSpeciesException(request.getTargetSpecies());
        }

        if (!formattedLifeStage.equals("KID") && !formattedLifeStage.equals("ADULT") && !formattedLifeStage.equals("SENIOR") && !formattedLifeStage.equals("ALL_STAGES")) {
            throw new InvalidLifeStageException(request.getLifeStage());
        }

        String uniqueFileName = fileUtils.saveProductImage(request.getFile());

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(uniqueFileName)
                .build();

        ProductDetail detail = ProductDetail.builder()
                .lifeStage(LifeStage.valueOf(formattedLifeStage))
                .targetSpecies(TargetSpecies.valueOf(formattedTargetSpecies))
                .brand(request.getBrand())
                .build();

        product.setProductDetail(detail);

        Product storedProduct = productRepository.save(product);
        log.info("Created product with id: {}", storedProduct.getId());

        return new CreateProductResponse(storedProduct);
    }

    @Override
    public Class<CreateProductRequest> getRequestType() {

        return CreateProductRequest.class;
    }
}
