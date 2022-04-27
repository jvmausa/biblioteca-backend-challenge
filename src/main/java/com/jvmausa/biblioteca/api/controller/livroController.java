package com.jvmausa.biblioteca.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jvmausa.biblioteca.api.assembler.LivroInputDisassembler;
import com.jvmausa.biblioteca.api.assembler.LivroModelAssembler;
import com.jvmausa.biblioteca.api.model.LivroModel;
import com.jvmausa.biblioteca.api.model.input.LivroInput;
import com.jvmausa.biblioteca.domain.model.Livro;
import com.jvmausa.biblioteca.domain.repository.LivroRepository;
import com.jvmausa.biblioteca.domain.service.CadastroLivroService;

@RestController
@RequestMapping(path = "/obras")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CadastroLivroService cadastroLivroService;

	@Autowired
	private LivroInputDisassembler livroInputDisassembler;

	@Autowired
	private LivroModelAssembler livroModelAssembler;

	@GetMapping
	public CollectionModel<LivroModel> listar() {
		return livroModelAssembler.toCollectionModel(livroRepository.findAll());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LivroModel adicionar(@RequestBody @Valid LivroInput livroInput) {

		Livro livro = livroInputDisassembler.toDomainObject(livroInput);

		return livroModelAssembler.toModel(cadastroLivroService.salvar(livro));

	}

	@PutMapping(path = "/{id}")
	public LivroModel atualizar(@PathVariable Long id, @RequestBody @Valid LivroInput livroInput) {

		Livro livroAtual = cadastroLivroService.buscarLivro(id);
		livroInputDisassembler.copyToDomainObject(livroInput, livroAtual);

		return livroModelAssembler.toModel(cadastroLivroService.salvar(livroAtual));

	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		cadastroLivroService.excluirLivro(id);

	}

}
