package com.digitech.reciskmodule.service.impl;

import com.digitech.reciskmodule.dto.CountryDto;
import com.digitech.reciskmodule.dto.RegionDto;
import com.digitech.reciskmodule.model.Country;
import com.digitech.reciskmodule.model.Region;
import com.digitech.reciskmodule.repository.RegionRepository;
import com.digitech.reciskmodule.service.IRegionService;
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
public class RegionService implements IRegionService, LoadJsonAndSaveEntity<Region> {
    private final RegionRepository regionRepository;
    @Override
    public RegionDto save(RegionDto entity) {
        return null;
    }

    @Override
    public List<RegionDto> save(List<RegionDto> entities) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<RegionDto> findById(String id) {
        RegionDto dto = new RegionDto();
        if (id == null){
            log.error("Region ID is null");
            return null;
        }
        Optional<Region> region = Optional.ofNullable(regionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "Region with ID = " + id + " not found"
                )
        ));

        dto.setName(region.get().getName());
        dto.setCode(region.get().getCode());

        return Optional.of(dto);
    }

    @Override
    public List<RegionDto> findAll() {
        return null;
    }

    @Override
    public Page<RegionDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public RegionDto update(RegionDto entity, String id) {
        return null;
    }

    @Override
    public List<RegionDto> loadJson(RegionDto entity) {
        return null;
    }

    @Override
    public List<Region> loadJsonAndSaveEntity() {
        ObjectMapper mapper = new ObjectMapper();
        List<Region> regionlist = new ArrayList<>();
        TypeReference<List<Region>> typeReference = new TypeReference<List<Region>>() {};
        InputStream inputStream =TypeReference.class.getResourceAsStream("/data/region.json");
        try {
            List<Region> region = mapper.readValue(inputStream, typeReference);
            regionlist= regionRepository.saveAll(region);
        }catch (IOException ex){
            log.info("Unable to save region : " +ex.getMessage());
        }
        return regionlist;
    }
}
