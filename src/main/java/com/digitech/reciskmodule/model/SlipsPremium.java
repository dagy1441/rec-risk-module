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
@Table(name = "slips_premium")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlipsPremium extends AbstractEntity{
    private String approval_status;
    @ManyToOne
    @JoinColumn(name = "cedants_id")
    private Cedant cedant;
    @ManyToOne
    @JoinColumn(name = "cedants_type_id")
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
