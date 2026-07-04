package com.petsproducts.product.application.query.getAll;

import com.petsproducts.common.application.mediator.RequestHandler;
import com.petsproducts.common.domain.PaginationResult;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllProductHandler implements RequestHandler<GetAllProductRequest, GetAllProductResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetAllProductResponse handle(GetAllProductRequest request) {
        PaginationResult<Product> products = productRepository.findAll(request.paginationQuery, request.productFilter);
        return new GetAllProductResponse(products);
    }

    @Override
    public Class<GetAllProductRequest> getRequestType() {
        return GetAllProductRequest.class;
    }
}

