package com.digitech.reciskmodule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cedant_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CedantType extends AbstractEntity{
    private String name;
}
