package com.jvmausa.biblioteca.domain.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private String titulo;
	private String editora;
	private String foto;

	
	
	/* Solução baseada em 
	 * https://stackoverflow.com/questions/287201/how-to-persist-a-property-of-type-liststring-in-jpa 
	 *  VIVA O STACKOVERFLOW
	 * */
	@ElementCollection
	@CollectionTable(name = "autor")
	@Column(name = "autores_list")
	private Collection<String> autores = new ArrayList<String>();

}
