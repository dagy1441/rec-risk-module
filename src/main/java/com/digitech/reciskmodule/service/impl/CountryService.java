package com.digitech.reciskmodule.service.impl;

import com.digitech.reciskmodule.dto.BrancheDto;
import com.digitech.reciskmodule.dto.CountryDto;
import com.digitech.reciskmodule.model.Alias;
import com.digitech.reciskmodule.model.Branche;
import com.digitech.reciskmodule.model.Country;
import com.digitech.reciskmodule.repository.CountryRepository;
import com.digitech.reciskmodule.service.ICountryService;
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
public class CountryService implements ICountryService, LoadJsonAndSaveEntity {
    private final CountryRepository countryRepository;

    @Override
    public CountryDto save(CountryDto entity) {
        return null;
    }

    @Override
    public List<CountryDto> save(List<CountryDto> entities) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<CountryDto> findById(String id) {
        CountryDto dto = new CountryDto();
        if (id == null){
            log.error("Country ID is null");
            return null;
        }
        Optional<Country> country = Optional.ofNullable(countryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "Country with ID = " + id + " not found"
                )
        ));

        dto.setName(country.get().getName());
        dto.setCode(country.get().getCode());
        dto.setRegion(country.get().getRegion());

        return Optional.of(dto);
    }

    @Override
    public List<CountryDto> findAll() {
        return null;
    }

    @Override
    public Page<CountryDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CountryDto update(CountryDto entity, String id) {
        return null;
    }

    @Override
    public List<CountryDto> loadJson(CountryDto entity) {
        return null;
    }

    @Override
    public List<Country> loadJsonAndSaveEntity() {
        ObjectMapper mapper = new ObjectMapper();
        List<Country> countrylist = new ArrayList<>();
        TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>() {};
        InputStream inputStream =TypeReference.class.getResourceAsStream("/data/countries.json");
        try {
            List<Country> country = mapper.readValue(inputStream, typeReference);
            countrylist= countryRepository.saveAll(country);
        }catch (IOException ex){
            log.info("Unable to save countries : " +ex.getMessage());
        }
        return countrylist;
    }

}
