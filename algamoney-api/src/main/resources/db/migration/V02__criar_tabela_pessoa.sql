CREATE TABLE pessoa (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) values ('Joao', 'rua joao amarela','111','casa','joao pereira','09088-234','Sao Paulo','SP',true);
INSERT INTO pessoa (nome, logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) values ('emilia','rua emilia azul','121','apartamento','emilia jardins','09088-235','Sao Paulo','SP',true);
INSERT INTO pessoa (nome, logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) values ('paulo', 'rua paulo vemelha','131','casa','paulo santo','09088-236','Sao Paulo','SP',true);
INSERT INTO pessoa (nome, logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) values ('pedro', 'rua pedro fonseca','141','apartamento','pedro alves','09088-237','Sao Paulo','SP',true);
INSERT INTO pessoa (nome, logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) values ('silva', 'rua silva preta','151','casa','silva de carvalho','09088-238','Sao Paulo','SP',true);
INSERT INTO pessoa (nome, logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) values ('vitor', 'rua vitor cinza','161','casa','vitor da conceiçao','09088-239','Sao Paulo','SP',true);