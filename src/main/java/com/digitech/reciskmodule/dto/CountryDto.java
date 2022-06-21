package com.digitech.reciskmodule.dto;

import com.digitech.reciskmodule.model.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private String code;
    private String name;
    private Region region;
}
