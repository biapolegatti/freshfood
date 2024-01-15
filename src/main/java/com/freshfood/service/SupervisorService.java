package com.freshfood.service;

import com.freshfood.exception.BadRequestException;
import com.freshfood.model.Supervisor;
import com.freshfood.model.Warehouse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SupervisorService {


    //Valida se o representante pertence ao armazém
    public Boolean hasSupervisorInWarehouse(List<Supervisor> supervisor, Warehouse warehouse) {
        var supervisors = warehouse.getSupervisors().stream()
                .anyMatch(s -> s.getId().equals(supervisor));

        if (supervisors) {
            return true;
        }
        throw new BadRequestException("Supervisor does not belong to the warehouse");
    }
}

