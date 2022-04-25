package com.jvmausa.biblioteca.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/obras/")
public class livroController {

	
	@GetMapping
	public String listar() {
		String texto = "estou aqui.";

		return texto;

	}

}
