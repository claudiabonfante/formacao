create table contas(

    id bigint not null auto_increment,
    agencia varchar(100) not null,
    conta varchar(100) not null unique,
    ativa tinyint,
    primary key(id)

);