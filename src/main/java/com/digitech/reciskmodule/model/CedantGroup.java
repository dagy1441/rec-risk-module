package com.digitech.reciskmodule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "groups_cedants")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CedantGroup extends AbstractEntity{
    private String name;
}
