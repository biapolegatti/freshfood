package com.freshfood.model;

import com.freshfood.enuns.SectionStorageEnum;
import com.freshfood.enuns.SectionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Warehouse warehouse;

    @Column(name = "section_type")
    @Enumerated(EnumType.STRING)
    private SectionTypeEnum sectionType;

    @OneToMany
    @Column(name = "product_id")
    private List<Product> products;

    @Column(name = "section_storage")
    @Enumerated(EnumType.STRING)
    private SectionStorageEnum sectionStorage;

    @Column(name = "quantity_products")
    private Long quantityProducts;

}
