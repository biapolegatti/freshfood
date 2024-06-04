package com.freshfood.service;

import com.freshfood.model.BatchStock;
import com.freshfood.repository.BatchStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BatchStockService {

    private BatchStockRepository batchStockRepository;

    public BatchStock save(BatchStock batchStock) {
        return batchStockRepository.save(batchStock);
    }
}
