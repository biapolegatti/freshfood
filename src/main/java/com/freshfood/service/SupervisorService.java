package com.freshfood.service;

import com.freshfood.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SupervisorService {

    private final WarehouseService warehouseService;


    //Valida se o representante pertence ao armazém
    public Boolean hasSupervisorInWarehouse(Long warehouseId, Long supervisorId) {
        var warehouse = warehouseService.findById(warehouseId);
        var supervisors = warehouse.getSupervisors().stream().anyMatch(s -> s.getId().equals(supervisorId));
//validar
        if (supervisors) {
            return true;
        }
        throw new BadRequestException("Supervisor does not belong to the warehouse");
    }
}

