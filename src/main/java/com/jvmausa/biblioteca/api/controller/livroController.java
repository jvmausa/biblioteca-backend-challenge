package com.jvmausa.biblioteca.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<Livro> listar() {
		List<Livro> livros = livroRepository.findAll();

		return livros;
	}

	@PostMapping()
	public LivroModel adicionar(@RequestBody @Valid LivroInput livroInput) {

		Livro livro = livroInputDisassembler.toDomainObject(livroInput);

		livro = cadastroLivroService.salvar(livro);

		LivroModel livroModel = livroModelAssembler.toModel(livro);

		return livroModel;

	}

	@PutMapping(path = "/{id}")
	public LivroModel atualizar(@PathVariable Long id, @RequestBody @Valid LivroInput livroInput) {

		Livro livroAtual = cadastroLivroService.buscarLivro(id);
		livroInputDisassembler.copyToDomainObject(livroInput, livroAtual);

		return livroModelAssembler.toModel(cadastroLivroService.salvar(livroAtual));

	}

}
