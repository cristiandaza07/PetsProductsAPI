package com.petsproducts.product.application.query.getById;

import com.petsproducts.common.application.mediator.RequestHandler;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.domain.exception.ProductNotFoundException;
import com.petsproducts.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductByIdHandler implements RequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {

        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new ProductNotFoundException(request.getId()));

        return new GetProductByIdResponse(product);

    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }
}
