package com.freshfood.service;

import com.freshfood.exception.NotFoundException;
import com.freshfood.model.Product;
import com.freshfood.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public Product findById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));
    }
}
