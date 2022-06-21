package com.digitech.reciskmodule.service;

import com.digitech.reciskmodule.dto.RecRiskRequestDto;
import com.digitech.reciskmodule.dto.RecRiskResponseDto;
import com.digitech.reciskmodule.model.CaseNotLifePremium;
import com.digitech.reciskmodule.model.RecRisk;

import java.util.List;

public interface IRecRiskService extends GenericService<RecRiskRequestDto, String>{
    public float calculateRec(String branche, String cedant, String slipesPrime);

    public RecRisk create(RecRiskRequestDto entity);

    public List<RecRiskResponseDto> findAllRisk();
}
