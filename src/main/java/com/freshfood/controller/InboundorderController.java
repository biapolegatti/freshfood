package com.freshfood.controller;


import com.freshfood.model.BatchStock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inboundorder")
public class InboundorderController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<BatchStock> create() {
        return null;

    }


}


