package com.freshfood.service;


import com.freshfood.dto.request.BatchStockRequest;
import com.freshfood.dto.request.InboundOrderRequest;
import com.freshfood.model.InboundOrder;
import com.freshfood.model.Section;
import com.freshfood.repository.InboundOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.freshfood.dto.mapper.InboundOrderMapper.toEntity;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class InboundOrderService {

    private final InboundOrderRepository inboundorderRepository;

    private final WarehouseService warehouseService;

    private final SectionService sectionService;

    //TODO: adicionar validação no request, está faltando e continuar vendo aspectos de melhoria aqui no metodo de create

    public InboundOrder create(InboundOrderRequest inboundOrderRequest) {
        warehouseService.findById(inboundOrderRequest.getSection().getWarehouseCode());

        var sectionUpdate = validateSection(inboundOrderRequest, inboundOrderRequest.getSection().getSectionCode());

        return inboundorderRepository.save(toEntity(inboundOrderRequest, sectionUpdate));
    }

    private Section validateSection(InboundOrderRequest inboundOrderRequest, Long sectionId) {
        var section = sectionService.findById(sectionId);
        var products = inboundOrderRequest.getBatchStock().stream()
                .map(BatchStockRequest::getProduct)
                .collect(toList());

        products.stream().allMatch(product -> sectionService.isValidSectionWithProductType(section, product.getSectionType()));

        return sectionService.addProductsInSection(inboundOrderRequest.getBatchStock(), section);
    }
}
