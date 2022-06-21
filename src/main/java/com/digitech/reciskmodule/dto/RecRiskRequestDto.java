package com.digitech.reciskmodule.dto;


import com.digitech.reciskmodule.model.RecRisk;
import com.digitech.reciskmodule.model.SlipsPremium;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecRiskRequestDto {


    private String slipsPremiumId;
    private String countryId;
    private String cedantId;
    private String branchId;


    //REC = Sum of the premium_ht * 36%

    public static RecRiskRequestDto fromEntity(RecRisk recRisk){
        if (recRisk == null) return null;
        return RecRiskRequestDto.builder()
                .branchId(recRisk.getBranche().getId())
                .cedantId(recRisk.getCedant().getId())
                .slipsPremiumId(recRisk.getSlipsPremium().getId())
                .countryId(recRisk.getCountry().getId())
                .build();
    }

    public static RecRisk toEntity(RecRiskRequestDto recRiskRequestDto){
        if (recRiskRequestDto == null) return null;
        RecRisk recRisk = new RecRisk();
        SlipsPremium slipsPremium = new SlipsPremium();
        slipsPremium.setId(recRiskRequestDto.getSlipsPremiumId());
        recRisk.setSlipsPremium(slipsPremium);

        return recRisk;
    }
}
