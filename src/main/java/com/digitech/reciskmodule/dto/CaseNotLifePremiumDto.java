package com.digitech.reciskmodule.dto;

import com.digitech.reciskmodule.model.Branche;
import com.digitech.reciskmodule.model.Cedant;
import com.digitech.reciskmodule.model.SlipsPremium;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaseNotLifePremiumDto{
    private float activeStatus;
    private String branch;
    private Branche Branches;
    private String caseValidationStatus;
    private String caseVariant;
    private String category;
    private Cedant Cedant;
    private float commissionCession;
    private String commissionRefunded = null;
    private String dateEffective;
    private String dateTansaction;
    private String deadline;
    private float insuredCpital;
    private String invoicedPemium = null;
    private String natureRiqueId;
    private String netAmount = null;
    private float paidCommission;
    private float paredantCass;
    private String policyNmber;
    private float premiumCded;
    private float premiumHT;
    private float primeNtCded;
    private SlipsPremium SlipePimeId;
}
