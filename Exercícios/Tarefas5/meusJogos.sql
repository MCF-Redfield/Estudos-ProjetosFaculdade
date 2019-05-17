create database meusJogos

use meusJogos

create table distribuidora(
  cod serial NOT NULL primary key,
  nome varchar(25) not NULL,
  sede varchar(20) not null
) ;

create table desenvolvedora(
  cod serial NOT NULL primary key,
  codDist smallint not null,
  nome varchar(25) not NULL,
  sede varchar(20) not null
) ;

ALTER TABLE desenvolvedora
ADD CONSTRAINT fk_dist_desenv FOREIGN KEY (codDist) REFERENCES distribuidora (cod);

create table jogo(
  cod serial NOT NULL primary key,
  codDesenv smallint not null,
  nome varchar(25) not null,
  plataforma varchar(30) not null,
  genero varchar(30) not null,
  status varchar(15) not null
  );

ALTER TABLE jogo
ADD CONSTRAINT fk_desenv_jogo FOREIGN KEY (codDesenv) REFERENCES desenvolvedora (cod);

