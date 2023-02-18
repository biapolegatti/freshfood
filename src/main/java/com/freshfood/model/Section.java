package com.freshfood.model;

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
    private Integer id;

    private SectionTypesEnum sectionTypesEnum;

    @ManyToOne
    private Warehouse warehouse;

}
