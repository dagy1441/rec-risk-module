package com.digitech.reciskmodule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cedants")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cedant extends AbstractEntity{
    private float benefit_percentage;
    private String code;
    private String color1;
    private String color2;
    private String contact;
    @ManyToOne
    @JoinColumn(name = "countries_id")
    private Country country;
    private String email;
    private String estimationType;
    @ManyToOne
    @JoinColumn(name = "groups_cedants_id")
    private CedantGroup cedantGroup;
    private String logo;
    private String name;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
