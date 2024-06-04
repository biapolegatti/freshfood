package com.freshfood.service;

import com.freshfood.exception.NotFoundException;
import com.freshfood.model.Supervisor;
import com.freshfood.repository.SupervisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SupervisorService {

    private SupervisorRepository supervisorRepository;

    public Supervisor findById(Long supersivorId) {
        return supervisorRepository.findById(supersivorId)
                .orElseThrow(() -> new NotFoundException("Supervisor not found"));
    }
}
