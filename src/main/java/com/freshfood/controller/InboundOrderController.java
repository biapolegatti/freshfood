package com.freshfood.controller;


import com.freshfood.dto.request.InboundOrderRequest;
import com.freshfood.model.BatchStock;
import com.freshfood.service.InboundOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inboundorder")
public class InboundOrderController {

    private final InboundOrderService inboundorderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BatchStock create(@RequestBody InboundOrderRequest inboundOrderRequest) {
        return inboundorderService.create(inboundOrderRequest);

    }
}

