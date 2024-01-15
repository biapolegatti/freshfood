package com.freshfood.dto.mapper;

import com.freshfood.dto.request.InboundOrderRequest;
import com.freshfood.model.InboundOrder;
import org.mapstruct.Mapper;

@Mapper
public interface InboundOrderMapper {

    InboundOrder toEntity(InboundOrderRequest inboundOrderRequest);
}
