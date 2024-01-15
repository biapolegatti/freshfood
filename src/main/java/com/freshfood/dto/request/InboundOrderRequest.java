package com.freshfood.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.freshfood.model.BatchStock;
import com.freshfood.model.Section;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InboundOrderRequest {

    private Long orderNumber;

    private Date orderDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Section section;

    @OneToMany(mappedBy = "inboundOrder")
    private List<BatchStock> batchStock;
}
