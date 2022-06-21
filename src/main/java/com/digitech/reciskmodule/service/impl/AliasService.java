package com.digitech.reciskmodule.service.impl;

import com.digitech.reciskmodule.dto.AliasDto;
import com.digitech.reciskmodule.dto.BrancheDto;
import com.digitech.reciskmodule.model.Alias;
import com.digitech.reciskmodule.model.Branche;
import com.digitech.reciskmodule.repository.AliasRepository;
import com.digitech.reciskmodule.service.IAliasService;
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
public class AliasService implements IAliasService, LoadJsonAndSaveEntity<Alias> {

    final AliasRepository aliasRepository;

    @Override
    public AliasDto save(AliasDto entity) {
        return null;
    }

    @Override
    public List<AliasDto> save(List<AliasDto> entities) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<AliasDto> findById(String id) {
        AliasDto dto = new AliasDto();
        if (id == null){
            log.error("Alias ID est null");
            return null;
        }
        Optional<Alias> alias = Optional.ofNullable(aliasRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "Alias with ID = " + id + "not found"
                )
        ));

        dto.setName(alias.get().getName());

        return Optional.of(dto);
    }

    @Override
    public List<AliasDto> findAll() {
        return null;
    }

    @Override
    public Page<AliasDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public AliasDto update(AliasDto entity, String id) {
        return null;
    }

    @Override
    public List<AliasDto> loadJson(AliasDto entity) {
        return null;
    }

    @Override
    public List<Alias> loadJsonAndSaveEntity() {
        ObjectMapper mapper = new ObjectMapper();
        List<Alias> aliaslist = new ArrayList<>();
        TypeReference<List<Alias>> typeReference = new TypeReference<List<Alias>>() {};
        InputStream inputStream =TypeReference.class.getResourceAsStream("/data/alias.json");
        try {
            List<Alias> alias = mapper.readValue(inputStream, typeReference);
            aliaslist= aliasRepository.saveAll(alias);
        }catch (IOException ex){
            log.info("Unable to save branches : " +ex.getMessage());
        }
        return aliaslist;
    }
}
