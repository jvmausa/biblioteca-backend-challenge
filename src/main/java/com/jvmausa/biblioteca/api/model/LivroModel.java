package com.jvmausa.biblioteca.api.model;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LivroModel extends RepresentationModel<LivroModel>{

	private Long id;

	private String titulo;
	private String editora;
	private String foto;
	
	private List<String> autores;
	
	
}
