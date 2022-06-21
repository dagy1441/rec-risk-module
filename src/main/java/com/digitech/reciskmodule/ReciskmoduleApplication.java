package com.digitech.reciskmodule;

import com.digitech.reciskmodule.model.Alias;
import com.digitech.reciskmodule.service.impl.AliasService;
import com.digitech.reciskmodule.service.impl.BrancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReciskmoduleApplication {

	@Autowired private AliasService aliasService;
	@Autowired private BrancheService brancheService;

	public static void main(String[] args) {
		SpringApplication.run(ReciskmoduleApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AliasService aliasService){
		return args -> {
			brancheService.loadJsonAndSaveEntity();
		};
	}

}
