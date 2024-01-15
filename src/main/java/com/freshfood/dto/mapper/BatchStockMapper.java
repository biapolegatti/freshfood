package com.freshfood.dto.mapper;

import com.freshfood.dto.BatchStockDto;
import com.freshfood.model.BatchStock;
import org.mapstruct.Mapper;

@Mapper
public interface BatchStockMapper {

    BatchStock toEntity(BatchStockDto batchStockDto);


}
