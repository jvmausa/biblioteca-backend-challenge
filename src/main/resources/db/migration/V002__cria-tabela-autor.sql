create table autor(
	id bigint not null auto_increment,
    autores_list varchar(255),
    livro_id bigint not null,
    
    constraint fk_livro_id foreign key (livro_id) references livro(id),
	primary key(id)
);