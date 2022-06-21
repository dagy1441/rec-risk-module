package com.digitech.reciskmodule.controller.api;

import com.digitech.reciskmodule.dto.RecRiskRequestDto;
import com.digitech.reciskmodule.dto.RecRiskResponseDto;
import com.digitech.reciskmodule.model.RecRisk;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static com.digitech.reciskmodule.constant.ApiConstant.APP_ROOT_URL;

@Api(value = APP_ROOT_URL+ "/recrisk")
public interface RecRiskApi {

    @PostMapping(
            value = APP_ROOT_URL + "/recrisk/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Enregistrer un recrisk",
            notes = "Cette methode permet d'enregistrer ou de modifier un recrisk",
            response = RecRiskResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide"),
    })
    @ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED, reason = "un recRisk enregistrer")
    ResponseEntity<RecRisk> save(@RequestBody RecRiskRequestDto dto);


    @GetMapping(value = APP_ROOT_URL+ "/recrisk/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Renvoi la liste des recrisk",
            notes = "Cette methode permet de renvoyer la liste des recrisk qui existent dans la BD",
            responseContainer = "List<RecRiskResponseDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Renvoi la liste des recrisk OU Une liste vide"),
    })
    ResponseEntity<List<RecRiskResponseDto>> findAll();

}
