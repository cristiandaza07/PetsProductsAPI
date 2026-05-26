package com.proyecto2026.web.product.infrastructure.database.mapper;

import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-24T13:33:19-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductEntityMapperImpl implements ProductEntityMapper {

    @Override
    public ProductEntity mapToProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setName( product.getName() );
        productEntity.setDescription( product.getDescription() );
        productEntity.setPrice( product.getPrice() );
        productEntity.setImage( product.getImage() );

        return productEntity;
    }

    @Override
    public Product mapToProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productEntity.getId() );
        product.name( productEntity.getName() );
        product.description( productEntity.getDescription() );
        product.price( productEntity.getPrice() );
        product.image( productEntity.getImage() );

        return product.build();
    }
}
