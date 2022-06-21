package com.digitech.reciskmodule.dto;

import com.digitech.reciskmodule.model.Country;
import com.digitech.reciskmodule.model.CedantGroup;
import com.digitech.reciskmodule.model.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CedantDto {
    private float benefit_percentage;
    private String code;
    private String color1;
    private String color2;
    private String contact;
    private Country country;
    private String email;
    private String estimationType;
    private CedantGroup cedantGroup;
    private String logo;
    private String name;
    private Region region;
}
