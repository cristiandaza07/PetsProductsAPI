package com.proyecto2026.web.product.infrastructure.api.mapper;

import com.proyecto2026.web.product.application.command.create.CreateProductRequest;
import com.proyecto2026.web.product.application.command.delete.DeleteProductRequest;
import com.proyecto2026.web.product.application.command.update.UpdateProductRequest;
import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.infrastructure.api.dto.CreateProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.ProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.UpdateProductDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-24T13:33:19-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public CreateProductRequest mapToCreateProductRequest(CreateProductDto createProductDto) {
        if ( createProductDto == null ) {
            return null;
        }

        String name = null;
        String description = null;
        Double price = null;
        MultipartFile file = null;

        name = createProductDto.getName();
        description = createProductDto.getDescription();
        price = createProductDto.getPrice();
        file = createProductDto.getFile();

        CreateProductRequest createProductRequest = new CreateProductRequest( name, description, price, file );

        return createProductRequest;
    }

    @Override
    public UpdateProductRequest mapToUpdateProductRequest(UpdateProductDto updateProductDto) {
        if ( updateProductDto == null ) {
            return null;
        }

        UpdateProductRequest updateProductRequest = new UpdateProductRequest();

        updateProductRequest.setId( updateProductDto.getId() );
        updateProductRequest.setName( updateProductDto.getName() );
        updateProductRequest.setDescription( updateProductDto.getDescription() );
        updateProductRequest.setPrice( updateProductDto.getPrice() );
        updateProductRequest.setFile( updateProductDto.getFile() );

        return updateProductRequest;
    }

    @Override
    public DeleteProductRequest mapToDeleteProductRequest(Long id) {
        if ( id == null ) {
            return null;
        }

        Long id1 = null;

        id1 = id;

        DeleteProductRequest deleteProductRequest = new DeleteProductRequest( id1 );

        return deleteProductRequest;
    }

    @Override
    public ProductDto mapToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setImage( product.getImage() );

        return productDto;
    }
}
