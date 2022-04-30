package com.jvmausa.biblioteca.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvmausa.biblioteca.domain.exceptionhandler.LivroNaoEncontradoException;
import com.jvmausa.biblioteca.domain.model.Livro;
import com.jvmausa.biblioteca.domain.repository.LivroRepository;

@Service
public class CadastroLivroService {

	public static boolean salvar;

	@Autowired
	private LivroRepository livroRepository;

	public Livro buscarLivro(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException(id));
	}

	@Transactional
	public Livro salvar(Livro livro) {
		return livroRepository.save(livro);
	}

	@Transactional
	public void excluirLivro(Long id) {

		try {
			livroRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException(id);
		}

	}

}
