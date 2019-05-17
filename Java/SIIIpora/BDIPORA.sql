create database siiipora;
use siiipora; 
CREATE TABLE anunciante (
  cpf varchar(15) NOT NULL,
  senha varchar(8) NOT NULL,
  nome varchar(45) DEFAULT NULL,
  PRIMARY KEY (cpf)
) ;
CREATE TABLE IF NOT EXISTS evento (
  id smallint NOT NULL AUTO_INCREMENT,
  nome varchar(45) DEFAULT NULL,
  local varchar(45) DEFAULT NULL,
  data date DEFAULT NULL,
  descricao varchar(250) DEFAULT NULL,
  campus varchar(45) DEFAULT NULL,
  anunciante_cpf varchar(14) NOT NULL,
  PRIMARY KEY (id)
) ;

ALTER TABLE evento
  ADD CONSTRAINT fk_evento_anunciante FOREIGN KEY (anunciante_cpf) REFERENCES anunciante (cpf) ON DELETE CASCADE;
