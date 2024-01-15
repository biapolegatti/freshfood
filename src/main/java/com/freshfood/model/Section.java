package com.freshfood.model;

import com.freshfood.enuns.SectionStorageEnum;
import com.freshfood.enuns.SectionTypesEnum;
import lombok.*;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private SectionTypesEnum sectionTypesEnum;

    @Enumerated(EnumType.STRING)
    private SectionStorageEnum sectionStorageEnum;

}
