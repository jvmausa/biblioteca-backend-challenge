package com.jvmausa.biblioteca.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jvmausa.biblioteca.api.controller.LivroController;
import com.jvmausa.biblioteca.api.model.LivroModel;
import com.jvmausa.biblioteca.domain.model.Livro;

@Component
public class LivroModelAssembler extends RepresentationModelAssemblerSupport<Livro, LivroModel> {

	@Autowired
	private ModelMapper modelMapper;

	public LivroModelAssembler() {
		super(LivroController.class, LivroModel.class);

	}

	@Override
	public LivroModel toModel(Livro livro) {
		return modelMapper.map(livro, LivroModel.class);

	}
	
	
	public CollectionModel<LivroModel> toCollectionModel(Iterable<? extends Livro> entities) {
		return super.toCollectionModel(entities);
		
	}
	
}
