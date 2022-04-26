set foreign_key_checks = 0;


delete from livro;
delete from autor;


set foreign_key_checks = 1;


alter table livro auto_increment = 1;
alter table autor auto_increment = 1;



