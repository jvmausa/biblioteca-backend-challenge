package com.jvmausa.biblioteca.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Livro {

	private Long id;
	private String titulo;
	private String editora;
	private String foto;
	private Set<String> autores = new HashSet<>();
	
	
}
