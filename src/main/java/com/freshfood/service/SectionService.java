package com.freshfood.service;


import com.freshfood.enuns.SectionStorageEnum;
import com.freshfood.exception.BadRequestException;
import com.freshfood.exception.NotFoundException;
import com.freshfood.model.Product;
import com.freshfood.model.Section;
import com.freshfood.repository.SectionReposiotory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SectionService {

    private final SectionReposiotory sectionReposiotory;

   /* E que o setor é válido
    E que o setor corresponde ao tipo de produto
    E que o setor tenha espaço disponíve*/

    public Section findById(Long id) {
        return sectionReposiotory.findById(id)
                .orElseThrow(() -> new NotFoundException("Section not found"));
    }

    public Boolean isValidSectionWithProdutType(Section section, Product product) {
        if (section.getSectionTypesEnum().equals(product.getSection().getSectionTypesEnum())) {
            return true;
        }
        throw new BadRequestException("Product does not correspond to the expected section");
    }

    //TODO: criei um ENUM para validar se existe espaço, mas é necessário desenvolver uma lógica dinâmica
    public Boolean isValidSectionStorage(Section section) {
        if (SectionStorageEnum.FULL.equals(section.getSectionStorageEnum())) {
            throw new BadRequestException("Warehouse has no storage space");
        }
        return true;
    }
}
