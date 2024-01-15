package com.freshfood.service;

import com.freshfood.exception.BadRequestException;
import com.freshfood.exception.NotFoundException;
import com.freshfood.model.Supervisor;
import com.freshfood.model.Warehouse;
import com.freshfood.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    //Valida se o armazém é válido
    public Warehouse findById(Long warehouseId) {
        return warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new NotFoundException("Warehouse not found"));
    }

    //Valida se o representante pertence ao armazém
    public Boolean validateSupervisorWithWarehouse(Supervisor supervisor, Warehouse warehouse) {
        List<Supervisor> supervisors = Optional.ofNullable(warehouse.getSupervisors()).orElse(Collections.emptyList());

        if (supervisors.contains(supervisor)) {
            return true;
        }
        throw new BadRequestException("Supervisor does not belong to the warehouse");
    }
}