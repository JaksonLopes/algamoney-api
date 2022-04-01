create table categoria(
                          id bigint not null primary key auto_increment,
                          nome varchar (60) not null
);
insert into categoria (nome) values ("lazer");
insert into categoria (nome) values ("Alimentação");
insert into categoria (nome) values ("supermercao");
insert into categoria (nome) values ("farmarcia");
insert into categoria (nome) values ("Outros");

