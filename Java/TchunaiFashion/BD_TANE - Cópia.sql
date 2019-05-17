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
) DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

create table cliente
(
   cpf varchar(14) not null,
   nomeCli varchar(30) not null,
   endereco varchar(50),
   email varchar(50),
   senha varchar(80),
   fone varchar(20),
   PRIMARY KEY(cpf)
) DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

create table pedido
(
   idPed smallint not null AUTO_INCREMENT,
   data date not null,
   cpfCli varchar(14) not null,
   total decimal(6,2) not null,
   PRIMARY KEY(idPed)
) DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

ALTER TABLE pedido
  ADD CONSTRAINT fk_pedido_cliente FOREIGN KEY (cpfCli) REFERENCES cliente (cpf) ON DELETE CASCADE;

create table pedProd
(
   idPed2 smallint not null,
   idProd2 smallint not null,
   tamanho varchar(3) not null,
   PRIMARY KEY(idPed2, idProd2)
) DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

ALTER TABLE pedProd
  ADD CONSTRAINT fk_pedProd_pedido FOREIGN KEY (idPed2) REFERENCES pedido (idPed) ON DELETE CASCADE,
  ADD CONSTRAINT fk_pedProd_produto FOREIGN KEY (idProd2) REFERENCES produto (idProd) ON DELETE CASCADE;

INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Camisa Xadrez Elegance', 'camisa', 'Camisa xadrez azul manga longa.', 'azul', 199.90, 'masculino', 'img/produtos/foto9-azul.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Dress Happy Green', 'vestido', 'Vestido verde de alça.', 'verde', 79.75, 'feminino', 'img/produtos/foto15-verde.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Camiseta Bad Girl', 'camiseta', 'Camiseta rosa com estampa de caveira.', 'rosa', 45.33, 'feminino', 'img/produtos/foto2-rosa.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Bermuda NotiBedi Style', 'bermuda', 'Bermuda jeans com estampa xadrez nas extremidades internas. Acompanha cinto.', 'azul', 121.99, 'masculino', 'img/produtos/bermuda1.png');
INSERT INTO tane.produto (`nomeProd`, tipo, descricao, cor, preco, genero, imagem) 
	VALUES ('Blazer Day Yellow', 'colete', 'Blazer feminino em camurça. Ideal para encontros formais ', 'amarelo', 220.99, 'feminino', 'img/produtos/blazerfem1.png');

