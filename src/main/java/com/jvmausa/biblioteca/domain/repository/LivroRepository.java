package com.jvmausa.biblioteca.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jvmausa.biblioteca.domain.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	public Livro findByAutores(String nome);

}
