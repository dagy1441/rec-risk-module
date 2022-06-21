package com.digitech.reciskmodule.service.impl;

import com.digitech.reciskmodule.dto.BrancheDto;
import com.digitech.reciskmodule.dto.CedantDto;
import com.digitech.reciskmodule.model.Branche;
import com.digitech.reciskmodule.model.Cedant;
import com.digitech.reciskmodule.repository.CedantRepository;
import com.digitech.reciskmodule.service.ICedantService;
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
public class CedantService implements ICedantService, LoadJsonAndSaveEntity<Cedant> {
    private final CedantRepository cedantRepository;

    @Override
    public CedantDto save(CedantDto entity) {
        return null;
    }

    @Override
    public List<CedantDto> save(List<CedantDto> entities) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<CedantDto> findById(String id) {
        CedantDto dto = new CedantDto();
        if (id == null){
            log.error("Cedant ID is null");
            return null;
        }
        Optional<Cedant> cedant = Optional.ofNullable(cedantRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "Cedant with ID = " + id + " not found"
                )
        ));

        dto.setName(cedant.get().getName());

        return Optional.of(dto);
    }

    @Override
    public List<CedantDto> findAll() {
        return null;
    }

    @Override
    public Page<CedantDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CedantDto update(CedantDto entity, String id) {
        return null;
    }

    @Override
    public List<CedantDto> loadJson(CedantDto entity) {
        return null;
    }

    @Override
    public List<Cedant> loadJsonAndSaveEntity() {
        ObjectMapper mapper = new ObjectMapper();
        List<Cedant> cedantList = new ArrayList<>();
        TypeReference<List<Cedant>> typeReference = new TypeReference<List<Cedant>>() {};
        InputStream inputStream =TypeReference.class.getResourceAsStream("/data/cedants.json");
        try {
            List<Cedant> cedants = mapper.readValue(inputStream, typeReference);
            cedantList= cedantRepository.saveAll(cedants);
        }catch (IOException ex){
            log.info("Unable to save branches : " +ex.getMessage());
        }
        return cedantList;
    }
}
