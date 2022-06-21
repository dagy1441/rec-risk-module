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
@Table(name = "case_not_life_premium")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseNotLifePremium extends AbstractEntity{

    private float active_status;
    private String branch;
    @ManyToOne
    @JoinColumn(name = "branches_id_object_id")
    private Branche branche;
    private String case_validation_status;
    private String case_variant;
    private String category;
    @ManyToOne
    @JoinColumn(name = "cedants_id_object_id")
    private Cedant Cedant;
    private float commission_cession;
    private String commission_refunded;
    private String date_effective;
    private String date_transaction;
    private String deadline;
    private float insured_capital;
    private String invoiced_premium;
    private String nature_risque_id;
    private String net_amount;
    private float paid_commission;
    private float part_cedant_coass;
    private String policy_number;
    private float premium_ceded;
    private float premium_ht;
    private float prime_net_ceded;
    @ManyToOne
    @JoinColumn(name = "slipes_prime_id")
    private SlipsPremium Slipes_prime_id;
}
