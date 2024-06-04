package com.freshfood.service;


import com.freshfood.dto.request.BatchStockRequest;
import com.freshfood.enuns.SectionStorageEnum;
import com.freshfood.enuns.SectionTypeEnum;
import com.freshfood.exception.BadRequestException;
import com.freshfood.exception.NotFoundException;
import com.freshfood.model.Section;
import com.freshfood.repository.SectionReposiotory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@RequiredArgsConstructor
@Service
public class SectionService {

    private final SectionReposiotory sectionReposiotory;

    private static final Long LIMIT_STORAGE = 15L;

    public Section findById(Long id) {
        return sectionReposiotory.findById(id)
                .orElseThrow(() -> new NotFoundException("Section not found"));
    }

    public Boolean isValidSectionWithProductType(Section section, SectionTypeEnum productSectionTypes) {
        if (Objects.equals(section.getSectionType(), productSectionTypes)) {
            return true;
        } else {
            throw new BadRequestException("Product does not correspond to the expected section");
        }
    }

    public Section addProductsInSection(List<BatchStockRequest> batchStockRequestList, Section section) {
        var totalItens = batchStockRequestList.stream().count();

        if (Objects.equals(hasSpaceForStorage(section), true) && totalItens < LIMIT_STORAGE) {
            section.setQuantityProducts(totalItens + section.getQuantityProducts());
            return sectionReposiotory.save(section);
        } else {
            throw new BadRequestException("Section has no storage space");
        }
    }

    public Boolean hasSpaceForStorage(Section section) {
        if (SectionStorageEnum.FULL.equals(section.getSectionStorage())) {
            throw new BadRequestException("Section has no storage space");
        }
        return true;
    }
}
