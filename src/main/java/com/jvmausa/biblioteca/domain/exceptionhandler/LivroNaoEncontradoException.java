package com.jvmausa.biblioteca.domain.exceptionhandler;

public class LivroNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public LivroNaoEncontradoException(Long id) {
		this(String.format("Não existe cadastro de Livro com id %d", id));
	}

}
