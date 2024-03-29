package com.freshfood.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InboundOrderRequest {

    private Long orderNumber;

    private Date orderDate;

    private SectionRequest section;

    private List<BatchStockRequest> batchStock;
}
