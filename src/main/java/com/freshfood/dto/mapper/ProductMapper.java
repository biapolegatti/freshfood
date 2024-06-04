package com.freshfood.dto.mapper;

import com.freshfood.dto.request.ProductRequest;
import com.freshfood.dto.response.ProductResponse;
import com.freshfood.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .sectionType(productRequest.getSectionType())
                .build();
    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .sectionType(product.getSectionType())
                .build();
    }
}
