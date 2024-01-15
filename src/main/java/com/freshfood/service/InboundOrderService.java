package com.freshfood.service;


import com.freshfood.dto.request.InboundOrderRequest;
import com.freshfood.model.BatchStock;
import com.freshfood.repository.InboundOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InboundOrderService {

    private final InboundOrderRepository inboundorderRepository;

    private final WarehouseService warehouseService;

    private final SupervisorService supervisorService;

    private final SectionService sectionService;

    /*  private final BatchStockMapper batchStockMapper;*/

    //InboundOrder = Pedido de entrada
    //BatchStock = lote
    //Warehouse = armazen
    //Section = seção

    /*QUERO inserir um lote de produtos no armazém de distribuição PARA registrar a existência de estoque

        E que o armazém é válido

        E que o representante pertence ao armazém

        E que o setor é válido
        E que o setor corresponde ao tipo de produto
        E que o setor tenha espaço disponível

        QUANDO o representante entra no setor
        ENTÃO o registro de compra é criado

        E o lote é atribuído a um setor
        E o representante é associado ao registro de estoque*/


    public BatchStock create(InboundOrderRequest inboundOrderRequest) {

        //busco o warehouse
        var warehouse = warehouseService.findById(inboundOrderRequest.getSection().getWarehouse().getId());


        //busco o supervisor
        var supersivor = supervisorService.hasSupervisorInWarehouse(inboundOrderRequest.getSection().getWarehouse().getSupervisors(),
                inboundOrderRequest.getSection().getWarehouse());

        //busco uma seção
        var section = sectionService.findById(inboundOrderRequest.getSection().getId());

        //seção corresponde ao tipo de produto
//        List<BatchStock> batchStocks = inboundOrderRequest.getBatchStock();
//
//        List<Product> productIds = batchStocks.stream()
//                .map(BatchStock::getProductId)
//                .collect(Collectors.toList());

//        for (var productId : productIds) {
//            boolean isValid = sectionService.isValidSectionWithProdutType(inboundOrderRequest.getSection(), productId);
//
//        }

        var sectionStorage = sectionService.isValidSectionStorage(inboundOrderRequest.getSection());


//        TODO: UTILIZAR MAPPER
//List  List      List<BatchStock> batchStockItens = batchStocks.stream()
//
//
//        BatchStock.builder()
//                .productId(batchStockItens.get)
//                .currentTemperature(inboundOrderRequest.getBatchStock())
//                .minimumTemperature()
//                .initialQuantity()
//                .currentQuantity()
//                .manufacturingDate()
//                .manufacturingTime()
//                .dueDate()
//                .build();




     /*   Foo.builder()
                .attribute1("Valor atributo 1")
                .attribute2(42)
                .attribute3(true)
                .build();*/


        return null;

    }
}
