package com.digitech.reciskmodule.service.impl;

import com.digitech.reciskmodule.dto.CedantDto;
import com.digitech.reciskmodule.model.Branche;
import com.digitech.reciskmodule.model.CaseNotLifePremium;
import com.digitech.reciskmodule.model.Cedant;
import com.digitech.reciskmodule.repository.CaseNotLifePremiumRepository;
import com.digitech.reciskmodule.service.ICaseNotLifePremiumService;
import com.digitech.reciskmodule.service.LoadJsonAndSaveEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CaseNotLifePremiumService implements ICaseNotLifePremiumService, LoadJsonAndSaveEntity<CaseNotLifePremium> {
    private final CaseNotLifePremiumRepository caseNotLifePremiumRepository;

    @Override
    public CaseNotLifePremium save(CaseNotLifePremium entity) {
        return null;
    }

    @Override
    public List<CaseNotLifePremium> save(List<CaseNotLifePremium> entities) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<CaseNotLifePremium> findById(String id) {
        CedantDto dto = new CedantDto();
        if (id == null){
            log.error("Cedant ID is null");
            return null;
        }
        Optional<CaseNotLifePremium> caseNotLifePremium = Optional.ofNullable(caseNotLifePremiumRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "Cedant with ID = " + id + " not found"
                )
        ));

        return Optional.of(caseNotLifePremium.get());
    }

    @Override
    public List<CaseNotLifePremium> findAll() {
        return caseNotLifePremiumRepository.findAll();
    }

    @Override
    public Page<CaseNotLifePremium> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CaseNotLifePremium update(CaseNotLifePremium entity, String id) {
        return null;
    }

    @Override
    public List<CaseNotLifePremium> loadJson(CaseNotLifePremium entity) {
        return null;
    }

    @Override
    public List<CaseNotLifePremium> loadJsonAndSaveEntity() {
        ObjectMapper mapper = new ObjectMapper();
        List<CaseNotLifePremium> caseNotLifePremiumList = new ArrayList<>();
        TypeReference<List<CaseNotLifePremium>> typeReference = new TypeReference<List<CaseNotLifePremium>>() {};
        InputStream inputStream =TypeReference.class.getResourceAsStream("/data/case_not_life_premium.json");
        try {
            List<CaseNotLifePremium> caseNotLifePremiums = mapper.readValue(inputStream, typeReference);
            caseNotLifePremiumList= caseNotLifePremiumRepository.saveAll(caseNotLifePremiums);
        }catch (IOException ex){
            log.info("Unable to save CaseNotLifePremium : " +ex.getMessage());
        }
        return caseNotLifePremiumList;
    }
}
