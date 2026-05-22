USE aula04;

DESCRIBE quartos;

ALTER TABLE quartos 
ADD COLUMN capacidade INT AFTER andar;

ALTER TABLE quartos
ADD COLUMN varanda VARCHAR(10) AFTER tipo;

ALTER TABLE quartos
ADD COLUMN tipo_varanda VARCHAR(30) AFTER varanda;

ALTER TABLE quartos
ADD COLUMN tamanho VARCHAR(20) AFTER tipo_varanda;

ALTER TABLE quartos
ADD UNIQUE (numero); 

SELECT * FROM quartos;

