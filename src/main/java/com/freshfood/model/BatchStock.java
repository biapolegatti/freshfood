package com.freshfood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class BatchStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inboundorder_id")
    @JsonIgnore
    private InboundOrder inboundOrder;

    //TODO: mudar esse mapeamento não é um list
    @OneToMany
    @JoinColumn(name = "batch_stock_id")
    private List<Product> productId;

    private Float currentTemperature;

    private Float minimumTemperature;

    private Integer initialQuantity;

    private Integer currentQuantity;

    private LocalDate manufacturingDate;

    private LocalDateTime manufacturingTime;

    private LocalDateTime dueDate;

}