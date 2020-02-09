package com.jai.springjpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "starting_material")
public class StartingMaterial {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String code;

    @ManyToOne(targetEntity = Component.class)
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private Component component;

}
