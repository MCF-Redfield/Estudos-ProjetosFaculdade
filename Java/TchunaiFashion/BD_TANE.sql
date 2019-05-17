drop database tane;
create database tane;
use tane;
create table produto
(
   idProd smallint not null AUTO_INCREMENT,
   nomeProd varchar(40) not null,
   tipo varchar(20) not null,
   descricao varchar(250) not null,
   cor varchar(25) not null,
   preco decimal(6,2) not null,
   genero varchar(10) not null,
   PRIMARY KEY(idProd),
   imagem varchar(50) not null
) DEFAULT CHARSET=latin1 COLLATE latin1_swedish_ci;

CREATE TABLE cliente (
cpf VARCHAR(14) NOT NULL,
 `nomeCli` VARCHAR(30) NOT NULL,
 email VARCHAR(50),
 senha VARCHAR(80),
 fone VARCHAR(20),
 numero VARCHAR(10) NOT NULL,
 cidade VARCHAR(30) NOT NULL,
 cep VARCHAR(20) NOT NULL,
 estado CHAR(2) NOT NULL,
 endereco VARCHAR(50) NOT NULL,
 bairro VARCHAR(30) NOT NULL,
 complemento VARCHAR(50),
 PRIMARY KEY (cpf)
) DEFAULT CHARSET=latin1 COLLATE latin1_swedish_ci;

create table pedido
(
   idPed smallint not null AUTO_INCREMENT,
   data date not null,
   cpfCli varchar(14) not null,
   total decimal(6,2) not null,
   PRIMARY KEY(idPed)
) DEFAULT CHARSET=latin1 COLLATE latin1_swedish_ci;

ALTER TABLE pedido
  ADD CONSTRAINT fk_pedido_cliente FOREIGN KEY (cpfCli) REFERENCES cliente (cpf) ON DELETE CASCADE;

create table pedProd
(
   idPedProd smallint not null AUTO_INCREMENT,
   idPed2 smallint not null,
   idProd2 smallint not null,
   tamanho varchar(3) not null,
   PRIMARY KEY(idPedProd,idPed2, idProd2)
) DEFAULT CHARSET=latin1 COLLATE latin1_swedish_ci;

ALTER TABLE pedProd
  ADD CONSTRAINT fk_pedProd_pedido FOREIGN KEY (idPed2) REFERENCES pedido (idPed) ON DELETE CASCADE,
  ADD CONSTRAINT fk_pedProd_produto FOREIGN KEY (idProd2) REFERENCES produto (idProd) ON DELETE CASCADE;

INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CamisaMasc1 CamisaMasc1', 'camisa', 'CamisaMasc1, CamisaMasc1, CamisaMasc1.', 'azul', 199.90, 'masculino', 'img/produtos/camisamasc1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CamisetaFem1 CamisetaFem1', 'camiseta', 'CamisetaFem1, CamisetaFem1, CamisetaFem1.', 'rosa', 45.33, 'feminino', 'img/produtos/camisetafem1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Vestido1 Vestido1', 'vestido', 'Vestido1, Vestido1, Vestido1.', 'azul', 79.75, 'feminino', 'img/produtos/vestido1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Bermuda1 Bermuda1', 'bermuda', 'Bermuda1, Bermuda1, Bermuda1.', 'azul', 121.99, 'masculino', 'img/produtos/bermuda1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Blazer Day Yellow', 'blazer', 'Blazer feminino em camurça. Ideal para encontros formais. ', 'amarelo', 220.99, 'feminino', 'img/produtos/blazerfem1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Blusa1 Blusa1', 'blusa', 'Blusa1, Blusa1, Blusa1. ', 'cinza', 89.99, 'feminino', 'img/produtos/blusa1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CalçaFem1 CalçaFem1', 'calça', 'CalçaFem1, CalçaFem1, CalçaFem1. ', 'azul', 100.99, 'feminino', 'img/produtos/calcafem1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CalçaMasc1 CalçaMasc1', 'calça', 'CalçaMasc1, CalçaMasc1, CalçaMasc1. ', 'marrom', 120.99, 'masculino', 'img/produtos/calcamasc1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CamisaFem1 CamisaFem1', 'camisa', 'CamisaFem1, CamisaFem1,CamisaFem1. ', 'varmelho', 145.99, 'feminino', 'img/produtos/camisafem1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Camiseta1 Camiseta1', 'camiseta', 'Camiseta1 Camiseta1 Camiseta1 Camiseta1. ', 'branco', 40.99, 'masculino', 'img/produtos/camiseta1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CamisaMasc2 CamisaMasc2', 'camisa', 'CamisaMasc2, CamisaMasc2, CamisaMasc2.', 'cinza', 199.90, 'masculino', 'img/produtos/camisamasc2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CamisetaFem2 CamisetaFem2', 'camiseta', 'CamisetaFem2, CamisetaFem2, CamisetaFem2.', 'rosa', 45.33, 'feminino', 'img/produtos/camisetafem2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Vestido2 Vestido2', 'vestido', 'Vestido2, Vestido2, Vestido2.', 'preto', 79.75, 'feminino', 'img/produtos/vestido2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Bermuda2 Bermuda2', 'bermuda', 'Bermuda2, Bermuda2, Bermuda2.', 'azul', 121.99, 'masculino', 'img/produtos/bermuda2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Blazer Night Red', 'blazer', 'Blazer feminino em camurça. Ideal para encontros formais. ', 'vermelho', 220.99, 'feminino', 'img/produtos/blazerfem2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Blusa2 Blusa2', 'blusa', 'Blusa2, Blusa2, Blusa2. ', 'azul', 89.99, 'feminino', 'img/produtos/blusa2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CalçaFem2 CalçaFem2', 'calça', 'CalçaFem2, CalçaFem2, CalçaFem2. ', 'cinza', 100.99, 'feminino', 'img/produtos/calcafem2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CalçaMasc2 CalçaMasc2', 'calça', 'CalçaMasc2, CalçaMasc2, CalçaMasc2. ', 'azul', 120.99, 'masculino', 'img/produtos/calcamasc2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('CamisaFem2 CamisaFem2', 'camisa', 'CamisaFem2, CamisaFem2,CamisaFem2. ', 'rosa', 145.99, 'feminino', 'img/produtos/camisafem2.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Camiseta2 Camiseta2', 'camiseta', 'Camiseta2 Camiseta2 Camiseta2 Camiseta2. ', 'verde', 40.99, 'masculino', 'img/produtos/camiseta2.png');

INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('babirolen skirt 63041', 'saia', 'Saia Classica', 'Preto', 299.99, 'feminino', 'img/produtos/saia1.png');

INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Suvinshop skirt 101404', 'saia', 'Saia2', 'Roxo Florido', 300.00, 'feminino', 'img/produtos/saia2.png');

INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Suvinshop skirt 101403', 'saia', 'Saia3', 'Preto Florido', 150.63, 'feminino', 'img/produtos/saia3.png');

INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('MiMi&DiDi skirt 12584', 'saia', 'Saia4', 'Branco', 500.75, 'feminino', 'img/produtos/saia4.png');

INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('babirolen skirt 62054', 'saia', 'Saia5', 'Preto', 400.00, 'feminino', 'img/produtos/saia5.png');







































