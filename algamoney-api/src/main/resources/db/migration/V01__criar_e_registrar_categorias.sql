CREATE TABLE categoria (
	id BIGINT (20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR (50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('Lazer');
INSERT INTO	categoria (nome) values ('Alimentaçao');
INSERT INTO	categoria (nome) values ('Supermercado');
INSERT INTO	categoria (nome) values ('Farmacia');
INSERT INTO	categoria (nome) values ('Outros');