package com.freshfood.dto.mapper;

import com.freshfood.dto.request.BatchStockRequest;
import com.freshfood.dto.response.BatchStockResponse;
import com.freshfood.model.BatchStock;

import java.util.List;
import java.util.stream.Collectors;

public class BatchStockMapper {

    public static List<BatchStock> toEntities(List<BatchStockRequest> batchStockRequests) {
        return batchStockRequests.stream()
                .map(batchStockRequest -> BatchStock.builder()
                        .productId(ProductMapper.toEntity(batchStockRequest.getProduct()))
                        .currentTemperature(batchStockRequest.getCurrentTemperature())
                        .minimumTemperature(batchStockRequest.getMinimumTemperature())
                        .initialQuantity(batchStockRequest.getInitialQuantity())
                        .currentQuantity(batchStockRequest.getCurrentQuantity())
                        .manufacturingDate(batchStockRequest.getManufacturingDate())
                        .manufacturingTime(batchStockRequest.getManufacturingTime())
                        .dueDate(batchStockRequest.getDueDate())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<BatchStockResponse> toResponsies(List<BatchStock> batchStocks) {
        return batchStocks.stream().map(batchStock -> BatchStockResponse.builder()
                        .batchNumber(batchStock.getId())
                        .product(ProductMapper.toResponse(batchStock.getProductId()))
                        .currentTemperature(batchStock.getCurrentTemperature())
                        .minimumTemperature(batchStock.getMinimumTemperature())
                        .initialQuantity(batchStock.getInitialQuantity())
                        .currentQuantity(batchStock.getCurrentQuantity())
                        .manufacturingDate(batchStock.getManufacturingDate())
                        .manufacturingTime(batchStock.getManufacturingTime())
                        .dueDate(batchStock.getDueDate())
                        .build())
                .collect(Collectors.toList());
    }
}
