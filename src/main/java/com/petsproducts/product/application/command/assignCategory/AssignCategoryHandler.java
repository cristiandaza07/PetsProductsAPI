package com.petsproducts.product.application.command.assignCategory;

import com.petsproducts.category.domain.entity.Category;
import com.petsproducts.category.domain.exception.CategoryNotFoundException;
import com.petsproducts.category.domain.port.CategoryRepository;
import com.petsproducts.common.application.mediator.RequestHandler;
import com.petsproducts.product.domain.entity.Product;
import com.petsproducts.product.domain.exception.ProductNotFoundException;
import com.petsproducts.product.domain.port.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class AssignCategoryHandler implements RequestHandler<AssignCategoryRequest, Void> {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public Void handle(AssignCategoryRequest request) {
        log.info("Assigning category to product");
        Product product = productRepository.findById(request.getProductId()).orElseThrow(() -> new ProductNotFoundException(request.getProductId()));

        Category category = categoryRepository.findByName(request.getCategoryName()).orElseThrow(() -> new CategoryNotFoundException(request.getCategoryName()));

        product.getCategories().add(category);

        productRepository.save(product);

        log.info("Category assigned to product");


        return null;
    }

    @Override
    public Class<AssignCategoryRequest> getRequestType() {
        return AssignCategoryRequest.class;
    }
}
