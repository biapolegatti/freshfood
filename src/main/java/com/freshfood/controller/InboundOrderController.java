package com.freshfood.controller;


import com.freshfood.dto.mapper.InboundOrderMapper;
import com.freshfood.dto.request.InboundOrderRequest;
import com.freshfood.dto.response.InboundOrderResponse;
import com.freshfood.service.InboundOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inbound-order")
public class InboundOrderController {

    private final InboundOrderService inboundOrderService;

    @PostMapping
    public InboundOrderResponse create(@RequestBody InboundOrderRequest inboundOrderRequest) {
        var inboundOrder = inboundOrderService.create(inboundOrderRequest);
        return InboundOrderMapper.toResponse(inboundOrder);
    }
}
