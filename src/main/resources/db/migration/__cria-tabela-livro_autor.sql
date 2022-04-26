create table livro_autor(
	livro_id bigint not null,
    autor_id bigint not null,
    
    primary key(livro_id, autor_id)
)