package com.digitech.reciskmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecRiskResponseDto {

    private String slipsPremiumReference;
    private String countryName;
    private String cedantName;
    private String confirmationStatus;
    private String validationStatus;
    private String publishedDate;
    private String branchName;
    private float premiumHt;
    private float rec;

}
