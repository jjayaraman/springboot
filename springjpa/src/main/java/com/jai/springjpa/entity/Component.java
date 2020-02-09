package com.jai.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "component")
@Data
@NoArgsConstructor
public class Component {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "cas_number")
    private String casNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "is_organic", columnDefinition = "boolean")
    private boolean isOrganic;

    @OneToMany//(mappedBy = "component")
    private List<StartingMaterial> startingMaterials;
}
