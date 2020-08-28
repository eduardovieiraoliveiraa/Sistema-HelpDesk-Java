create database ProjetoHelpDesk;

CREATE TABLE tb_Setor(

	IdSetor INT primary key auto_increment,
    nome_Setor VARCHAR(30) NOT NULL


);

select *from tb_Setor; 


INSERT INTO tb_setor(nome_Setor) VALUES("ADMIN");

CREATE TABLE tb_Usuario (


	IdUsuario INT primary key auto_increment,
    nome_Usuario varchar(50) NOT NULL,
    email varchar(60) not null,
    grupo varchar(20) not null,
    usuarioLogin varchar  (20) not null unique,
    senha varchar(20) not null,
    IdSetor INT,
   constraint fk_usuario_setor foreign key tb_Setor(IdSetor)references tb_Setor(IdSetor)
 
);

INSERT INTO tb_Usuario(nome_Usuario, email,grupo, usuarioLogin, senha, IdSetor) VALUES("ADMIN","TECNICO","ADMIN","ADMIN","ADMIN",1);
select *from tb_usuario; 

CREATE TABLE tb_Problema(

	IdProblema INT primary key auto_increment,
    tipo varchar(50) NOT NULL

);


create table tb_Chamado (

	IdChamado INT primary key auto_increment,
    titulo_Chamado varchar(100) NOT NULL,
    urgencia varchar(20) NOT NULL,
    descricao varchar(300) NOT NULL,
    data_Abertura timestamp,
    data_Fechado timestamp default current_timestamp,
    tipoChamado varchar(30),
	tecnico varchar(30),
    status_chamado varchar(20),
    IdUsuario INT,
    IdProblema INT,
	IdSolucao INT,
     constraint fk_chamado_usuario foreign key tb_Usuario(IdUsuario)references tb_Usuario(IdUsuario),
      constraint fk_chamado_problema foreign key tb_Problema(IdProblema)references tb_Problema(IdProblema),
       constraint fk_chamado_solucao foreign key tb_Solucao(IdSolucao)references tb_Solucao(IdSolucao)
  
);

create table tb_Solucao(

	IdSolucao INT primary key auto_increment,
    solucao varchar(300) not null

);
 



