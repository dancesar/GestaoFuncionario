package com.gestao.GestaoFuncionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GestaoFuncionarioApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(GestaoFuncionarioApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GestaoFuncionarioApplication.class, args);
	}

}
