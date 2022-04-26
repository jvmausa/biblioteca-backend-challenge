package com.jvmausa.biblioteca.api.model.input;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LivroInput {
	
	private String titulo;
	private String editora;
	private String foto;
	
	private List<String> autores;
	
}
