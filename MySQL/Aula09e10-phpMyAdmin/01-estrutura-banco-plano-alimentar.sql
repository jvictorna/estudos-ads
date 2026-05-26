CREATE DATABASE IF NOT EXISTS planoalimentaraula09
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE planoalimentaraula09;

CREATE TABLE resumo_do_dia_base (
id INT NOT NULL AUTO_INCREMENT,
refeicao VARCHAR(30),
horario TIME,
proteina VARCHAR(10),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE variacoes_quinta_feira (
id INT NOT NULL AUTO_INCREMENT,
semana VARCHAR(20),
proteina_especial VARCHAR(30),
quantidade VARCHAR(20),
proteina_estimada VARCHAR(10),
PRIMARY KEY (id) 
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE referencias (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40), 
proteina_sozinho VARCHAR(10),
combinacao_sugerida VARCHAR(40),
proteina_combinada VARCHAR(10),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE praticas_referencias (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
quantidade_base VARCHAR(30),
meta_proteina VARCHAR(10), 
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE pre_treino (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE cafe_principal (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE almoco (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE lanche_trabalho (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE refeicao_trabalho (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE ceia (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE semana1 (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE semana2 (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE semana3 (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 

CREATE TABLE semana4 (
id INT NOT NULL AUTO_INCREMENT,
alimento VARCHAR(40),
proteina VARCHAR(5),
obs VARCHAR(50),
PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4; 
