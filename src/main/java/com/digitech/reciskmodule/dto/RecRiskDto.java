package com.digitech.reciskmodule.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecRiskDto {
    private String reference;
    private String countryName;
    private String confirmationStatus;
    private String publishedDate;
    private String branchName;
    private float premiumHt;
    private float rec;

    //REC = Sum of the premium_ht * 36%
}
