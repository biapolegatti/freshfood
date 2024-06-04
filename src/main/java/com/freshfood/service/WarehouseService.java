package com.freshfood.service;

import com.freshfood.exception.BadRequestException;
import com.freshfood.exception.NotFoundException;
import com.freshfood.model.Warehouse;
import com.freshfood.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public Warehouse findById(Long warehouseId) {
        return warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new NotFoundException("Warehouse not found"));
    }

    public Boolean validateSupervisorWithWarehouse(Long supervisorId, Long warehouseId) {
        var warehouse = findById(warehouseId);
        var supervisors = Optional.ofNullable(warehouse.getSupervisors()).orElse(Collections.emptyList());

        if (supervisors.stream().anyMatch(s -> s.getId().equals(supervisorId))) {
            return true;
        } else {
            throw new BadRequestException("Supervisor does not belong to the warehouse");
        }
    }
}