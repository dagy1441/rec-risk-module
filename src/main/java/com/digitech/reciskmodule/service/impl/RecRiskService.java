package com.digitech.reciskmodule.service.impl;

import com.digitech.reciskmodule.dto.RecRiskRequestDto;
import com.digitech.reciskmodule.dto.RecRiskResponseDto;
import com.digitech.reciskmodule.exception.EntityNotFoundException;
import com.digitech.reciskmodule.model.*;
import com.digitech.reciskmodule.repository.*;
import com.digitech.reciskmodule.service.IRecRiskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class RecRiskService implements IRecRiskService {

    private final RecRiskRepository recRiskRepository;
    private final BrancheRepository brancheRepository;
    private final CedantRepository cedantRepository;
    private final CountryRepository countryRepository;
    private final SlipsPremiumRepository slipsPremiumRepository;
    private final CaseNotLifePremiumRepository caseNotLifePremiumRepository;


    @Override
    public RecRisk create(RecRiskRequestDto entity) {
        RecRisk recRisk = new RecRisk();

        Optional<SlipsPremium> slipsPremium = slipsPremiumRepository.findById(entity.getSlipsPremiumId());

        if (!slipsPremium.isPresent()){
            log.warn("slipsPremium with ID {} was not found in he DB ", entity.getSlipsPremiumId());
            throw new EntityNotFoundException(
                    "slipsPremium with ID "
                            +entity.getSlipsPremiumId()+
                            "was not found");
        }

        Optional<Branche> branche = brancheRepository.findById(entity.getBranchId());
        if (!branche.isPresent()){
            log.warn("Branche with ID {} was not found in he DB ", entity.getBranchId());
            throw new EntityNotFoundException(
                    "Branche with ID "
                            +entity.getBranchId()+
                            " was not found");
        }

        Optional<Country> country = countryRepository.findById(entity.getCountryId());
        if (!country.isPresent()){
            log.warn("Country with ID {} was not found in he DB ", entity.getCountryId());
            throw new EntityNotFoundException(
                    "Country with ID "
                            + entity.getCountryId() +
                            " was not found");
        }

        Optional<Cedant> cedant = cedantRepository.findById(entity.getCedantId());
        if (!cedant.isPresent()){
            log.warn("Cedant with ID {} was not found in he DB ", entity.getCedantId());
            throw new EntityNotFoundException(
                    "Cedant with ID "
                            + entity.getCedantId() +
                            " was not found");
        }


        Country newcountry= new Country();
        newcountry.setId(entity.getSlipsPremiumId());
        recRisk.setCountry(newcountry);

        Cedant newcedant = new Cedant();
        newcedant.setId(entity.getCedantId());
        recRisk.setCedant(newcedant);

        Branche newbranche = new Branche();
        newbranche.setId(entity.getBranchId());
        recRisk.setBranche(newbranche);

        SlipsPremium newslipsPremium = new SlipsPremium();
        newslipsPremium.setId(entity.getSlipsPremiumId());
        recRisk.setSlipsPremium(newslipsPremium);

        recRisk.setRec(calculateRec(branche.get().getId(), cedant.get().getId(), slipsPremium.get().getReference()));

        return recRisk;
    }

    @Override
    public List<RecRiskResponseDto> findAllRisk() {

        List<RecRisk> recRiskList = recRiskRepository.findAll();

        SlipsPremium slipsPremium = new SlipsPremium();
        List<SlipsPremium> slipsPremiumList = new ArrayList<>();

        Branche branche;
        List<Branche> brancheList = new ArrayList<>();

        Country country;
        List<Country> countryList = new ArrayList<>();

        Cedant cedant;
        List<Cedant> cedantList = new ArrayList<>();

        RecRiskResponseDto dto = new RecRiskResponseDto();

        List<RecRiskResponseDto> responseDto = new ArrayList<>();

        for (RecRisk risk: recRiskList) {

             slipsPremium = slipsPremiumRepository.findById(risk.getSlipsPremium().getId()).get();
             slipsPremiumList.add(slipsPremium);

             branche = brancheRepository.findById(risk.getBranche().getId()).get();
             brancheList.add(branche);

             country = countryRepository.findById(risk.getCountry().getId()).get();
             countryList.add(country);

             cedant = cedantRepository.findById(risk.getCedant().getId()).get();
             cedantList.add(cedant);
             dto.setRec(risk.getRec());
             responseDto.add(dto);

        }

        String reference;


        for (SlipsPremium slip: slipsPremiumList) {
            dto.setSlipsPremiumReference(slip.getReference());
            dto.setConfirmationStatus(slip.getConfirmationStatus());
            dto.setValidationStatus(slip.getValidationStatus());
            dto.setPublishedDate(slip.getPublishedDate());
            responseDto.add(dto);
        }

        countryList.forEach( (name) -> {
            dto.setCountryName(String.valueOf(name));
            responseDto.add(dto);
        });

        cedantList.forEach( (name) -> {
            dto.setCedantName(String.valueOf(name));
            responseDto.add(dto);
        });

        brancheList.forEach( (name) -> {
            dto.setBranchName(String.valueOf(name));
            responseDto.add(dto);
        });


        return responseDto;
    }


    @Override
    public RecRiskRequestDto save(RecRiskRequestDto entity) {
        RecRisk recRisk = new RecRisk();

        Optional<SlipsPremium> slipsPremium = slipsPremiumRepository.findById(entity.getSlipsPremiumId());

        if (!slipsPremium.isPresent()){
            log.warn("slipsPremium with ID {} was not found in he DB ", entity.getSlipsPremiumId());
            throw new EntityNotFoundException(
                    "slipsPremium with ID "
                            +entity.getSlipsPremiumId()+
                            "was not found");
        }

        Optional<Branche> branche = brancheRepository.findById(entity.getBranchId());
        if (!branche.isPresent()){
            log.warn("Branche with ID {} was not found in he DB ", entity.getBranchId());
            throw new EntityNotFoundException(
                    "Branche with ID "
                            +entity.getBranchId()+
                            " was not found");
        }

        Optional<Country> country = countryRepository.findById(entity.getCountryId());
        if (!country.isPresent()){
            log.warn("Country with ID {} was not found in he DB ", entity.getCountryId());
            throw new EntityNotFoundException(
                    "Country with ID "
                            + entity.getCountryId() +
                            " was not found");
        }

        Optional<Cedant> cedant = cedantRepository.findById(entity.getCedantId());
        if (!cedant.isPresent()){
            log.warn("Cedant with ID {} was not found in he DB ", entity.getCedantId());
            throw new EntityNotFoundException(
                    "Cedant with ID "
                            + entity.getCedantId() +
                            " was not found");
        }


        recRisk.setBranche(branche.get());
        recRisk.setCedant(cedant.get());
        recRisk.setCountry(country.get());
        recRisk.setSlipsPremium(slipsPremium.get());


       return null;
    }

    @Override
    public List<RecRiskRequestDto> save(List<RecRiskRequestDto> entities) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<RecRiskRequestDto> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<RecRiskRequestDto> findAll() {
        return null;
    }

    @Override
    public Page<RecRiskRequestDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public RecRiskRequestDto update(RecRiskRequestDto entity, String id) {
        return null;
    }

    @Override
    public List<RecRiskRequestDto> loadJson(RecRiskRequestDto entity) {
        return null;
    }

    @Override
    public float calculateRec(String branche, String cedant, String slipesPrime) {
       Optional<CaseNotLifePremium> caseNotLifePremiums =
               Optional.ofNullable(
                       caseNotLifePremiumRepository
                               .findByBrancheAndCedant(branche, cedant, slipesPrime)
                               .orElseThrow(
                       () -> new EntityNotFoundException("ID not found")
               ));
          float rec =  (caseNotLifePremiums.get().getPremium_ht()*36)/100;
        return rec;
    }


}
