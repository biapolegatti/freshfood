package com.freshfood.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class InboundOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderNumber;

    private Date orderDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Section section;

    @OneToMany(mappedBy = "inboundOrder")
    private List<BatchStock> batchStock;

}
