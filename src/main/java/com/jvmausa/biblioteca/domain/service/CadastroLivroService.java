package com.jvmausa.biblioteca.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvmausa.biblioteca.domain.model.Livro;
import com.jvmausa.biblioteca.domain.repository.LivroRepository;

@Service
public class CadastroLivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro buscarLivro(Long id) {
		return livroRepository.findById(id).orElseThrow(/* TODO criar exception personalizada */);
	}

	@Transactional
	public Livro salvar(Livro livro) {
		
		return livroRepository.save(livro);

	}

}
