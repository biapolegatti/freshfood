package com.freshfood.dto.mapper;

import com.freshfood.dto.request.InboundOrderRequest;
import com.freshfood.dto.response.InboundOrderResponse;
import com.freshfood.model.InboundOrder;
import com.freshfood.model.Section;

public class InboundOrderMapper {

    public static InboundOrder toEntity(InboundOrderRequest inboundOrderRequest, Section section) {
        return InboundOrder.builder()
                .orderNumber(inboundOrderRequest.getOrderNumber())
                .orderDate(inboundOrderRequest.getOrderDate())
                .section(section)
                .batchStock(BatchStockMapper.toEntities(inboundOrderRequest.getBatchStock()))
                .build();
    }

    public static InboundOrderResponse toResponse(InboundOrder inboundOrder) {
        return InboundOrderResponse.builder()
                .batchStock(BatchStockMapper.toResponsies(inboundOrder.getBatchStock()))
                .build();
    }
}
