create table if not exists dentista(
id int primary key auto_increment,
nome varchar(30) not null,
sobrenome varchar(30) not null,
matricula varchar(15) not null unique,
senha varchar(10) not null,
tipo enum('cliente', 'administrador') not null
);

create table if not exists paciente(
id int primary key auto_increment,
nome varchar(30) not null,
sobrenome varchar(30) not null,
rg varchar(15) not null unique,
dataAlta Date,
senha varchar(10) not null,
tipo enum('cliente', 'administrador') not null
);

create table if not exists consulta(
id int primary key auto_increment,
data Date,
hora Time,
idDentista int,
foreign key(idDentista)
references dentista(id),
idPaciente int,
foreign key(idPaciente)
references paciente(id)
);

create table if not exists endereco(
id int primary key auto_increment,
logradouro varchar(10) not null,
endereco varchar(100) not null,
numero varchar(5) not null,
cidade varchar(20) not null,
estado char(2) not null,
cep char(8) not null,
idPaciente int,
foreign key (idPaciente)
references paciente(id)
);
