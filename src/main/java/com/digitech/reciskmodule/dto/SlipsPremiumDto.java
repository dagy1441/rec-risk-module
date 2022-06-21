package com.digitech.reciskmodule.dto;

import com.digitech.reciskmodule.model.Cedant;
import com.digitech.reciskmodule.model.CedantType;
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
public class SlipsPremiumDto {
    private String approvalStatus;
    private Cedant cedant;
    private CedantType CedantsType;
    private String commissionRefundedTotal = null;
    private String confirmationDate;
    private String confirmationStatus;
    private String editedPeriod;
    private String fileUrl;
    private String invoicePremiumTotal = null;
    private float isPaid;
    private String netAmountTotal = null;
    private String publishedDate;
    private String reference;
    private String slipType;
    private float updateProgress;
    private float updateStatus;
    private String validationDate;
    private String validationStatus;
    private float warningsSaved;
}
