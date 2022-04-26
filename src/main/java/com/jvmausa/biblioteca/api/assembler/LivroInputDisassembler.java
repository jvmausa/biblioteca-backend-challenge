package com.jvmausa.biblioteca.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jvmausa.biblioteca.api.model.input.LivroInput;
import com.jvmausa.biblioteca.domain.model.Livro;

@Component
public class LivroInputDisassembler {

	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Livro toDomainObject(LivroInput livroInput) {
		return modelMapper.map(livroInput, Livro.class);
		
	}
	
	public void copyToDomainObject(LivroInput livroInput, Livro livro) {
		modelMapper.map(livroInput, livro);
	}
	
}
