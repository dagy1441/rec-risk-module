package com.digitech.reciskmodule.controller;

import com.digitech.reciskmodule.controller.api.RecRiskApi;
import com.digitech.reciskmodule.dto.RecRiskRequestDto;
import com.digitech.reciskmodule.dto.RecRiskResponseDto;
import com.digitech.reciskmodule.model.RecRisk;
import com.digitech.reciskmodule.service.impl.RecRiskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class RecRiskController implements RecRiskApi {

    private final RecRiskService recRiskService;
    @Override
    public ResponseEntity<RecRisk> save(RecRiskRequestDto dto) {

        return  ResponseEntity.ok(recRiskService.create(dto));
    }

    @Override
    public ResponseEntity<List<RecRiskResponseDto>> findAll() {
        return ResponseEntity.ok(recRiskService.findAllRisk());
    }
}
