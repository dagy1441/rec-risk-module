package com.digitech.reciskmodule.service.impl;

import com.digitech.reciskmodule.dto.BrancheDto;
import com.digitech.reciskmodule.model.Alias;
import com.digitech.reciskmodule.model.Branche;
import com.digitech.reciskmodule.repository.BrancheRepository;
import com.digitech.reciskmodule.service.IBrancheService;
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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrancheService implements IBrancheService, LoadJsonAndSaveEntity {

    final BrancheRepository brancheRepository;

    @Override
    public BrancheDto save(BrancheDto entity) {
        return null;
    }

    @Override
    public List<BrancheDto> save(List<BrancheDto> entities) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<BrancheDto> findById(String id) {
        BrancheDto dto = new BrancheDto();
        if (id == null){
            log.error("Branche ID is null");
            return null;
        }
        Optional<Branche> branche = Optional.ofNullable(brancheRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "Branch with ID = " + id + " not found"
                )
        ));

        dto.setAlias(branche.get().getAlias());
        dto.setCode(branche.get().getCode());
        dto.setParentBranchId(branche.get().getParent_branch_id());
        dto.setIsParent(branche.get().getIs_parent());
        dto.setName(branche.get().getName());
        dto.setStatus(branche.get().getStatus());
        dto.setType(branche.get().getType());

        return Optional.of(dto);
    }

    @Override
    public List<BrancheDto> findAll() {
        return null;
    }

    @Override
    public Page<BrancheDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public BrancheDto update(BrancheDto entity, String id) {
        return null;
    }

    @Override
    public List<BrancheDto> loadJson(BrancheDto entity) {
        return null;
    }


    @Override
    public List loadJsonAndSaveEntity() {
        ObjectMapper mapper = new ObjectMapper();
        List<Branche> brancheList = new ArrayList<>();
        TypeReference<List<Branche>> typeReference = new TypeReference<List<Branche>>() {};
        InputStream inputStream =TypeReference.class.getResourceAsStream("/data/branches.json");
        try {
            List<Branche> branches = mapper.readValue(inputStream, typeReference);
            brancheList= brancheRepository.saveAll(branches);
        }catch (IOException ex){
            log.info("Unable to save branches : " +ex.getMessage());
        }
        return brancheList;
    }
}
