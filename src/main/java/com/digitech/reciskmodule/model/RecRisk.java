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
@Table(name = "rec_risk")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecRisk extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "slips_premium_id")
    private SlipsPremium slipsPremium;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "cedant_id")
    private Cedant cedant;

    @ManyToOne
    @JoinColumn(name = "branche_id")
    private Branche branche;

    private Float rec;
}
