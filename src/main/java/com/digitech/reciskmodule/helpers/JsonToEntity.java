package com.digitech.reciskmodule.helpers;

import com.digitech.reciskmodule.model.Branche;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonToEntity <E>{


    public List<E> saveJsonToEntity() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<E>> typeReference = new TypeReference<List<E>>() {};
        InputStream inputStream =TypeReference.class.getResourceAsStream("/data/branches.json");
        List<E> eList = new ArrayList<>();
        try {
            eList = mapper.readValue(inputStream, typeReference);
        }catch (IOException ex){
            log.info("Unable to save branches : " +ex.getMessage());
        }

        return eList;
    }
}
