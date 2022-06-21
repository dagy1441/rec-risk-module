package com.digitech.reciskmodule.service.impl;

import com.digitech.reciskmodule.dto.RegionDto;
import com.digitech.reciskmodule.dto.SlipsPremiumDto;
import com.digitech.reciskmodule.model.Region;
import com.digitech.reciskmodule.model.SlipsPremium;
import com.digitech.reciskmodule.repository.SlipsPremiumRepository;
import com.digitech.reciskmodule.service.ISlipPremiumService;
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
public class SlipsPremiumService implements ISlipPremiumService, LoadJsonAndSaveEntity<SlipsPremium> {

    private final SlipsPremiumRepository slipsPremiumRepository;

    @Override
    public SlipsPremiumDto save(SlipsPremiumDto entity) {
        return null;
    }

    @Override
    public List<SlipsPremiumDto> save(List<SlipsPremiumDto> entities) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<SlipsPremiumDto> findById(String id) {
        SlipsPremiumDto dto = new SlipsPremiumDto();
        if (id == null){
            log.error("SlipsPremium ID is null");
            return null;
        }
        Optional<SlipsPremium> slipsPremium = Optional.ofNullable(slipsPremiumRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "SlipsPremium with ID = " + id + " not found"
                )
        ));

        dto.setReference(slipsPremium.get().getReference());

        return Optional.of(dto);
    }

    @Override
    public List<SlipsPremiumDto> findAll() {
        return null;
    }

    @Override
    public Page<SlipsPremiumDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public SlipsPremiumDto update(SlipsPremiumDto entity, String id) {
        return null;
    }

    @Override
    public List<SlipsPremiumDto> loadJson(SlipsPremiumDto entity) {
        return null;
    }

    @Override
    public List<SlipsPremium> loadJsonAndSaveEntity() {
        ObjectMapper mapper = new ObjectMapper();
        List<SlipsPremium> slipsPremiumList = new ArrayList<>();
        TypeReference<List<SlipsPremium>> typeReference = new TypeReference<List<SlipsPremium>>() {};
        InputStream inputStream =TypeReference.class.getResourceAsStream("/data/slips_premium.json");
        try {
            List<SlipsPremium> slipsPremiums = mapper.readValue(inputStream, typeReference);
            slipsPremiumList= slipsPremiumRepository.saveAll(slipsPremiums);
        }catch (IOException ex){
            log.info("Unable to save slipsPremiumList : " +ex.getMessage());
        }
        return slipsPremiumList;
    }
}
