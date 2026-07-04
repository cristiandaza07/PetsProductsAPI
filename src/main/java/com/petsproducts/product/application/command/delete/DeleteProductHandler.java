package com.petsproducts.product.application.command.delete;

import com.petsproducts.common.application.mediator.RequestHandler;
import com.petsproducts.product.domain.port.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class DeleteProductHandler implements RequestHandler<DeleteProductRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(DeleteProductRequest request) {

        productRepository.deleteById(request.getId());
        return null;
    }

    @Override
    public Class<DeleteProductRequest> getRequestType() {

        return DeleteProductRequest.class;
    }
}
