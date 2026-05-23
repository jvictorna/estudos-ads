USE aula04;

SELECT * FROM quartos;

TRUNCATE table quartos;

INSERT INTO quartos
(numero, andar, capacidade, tipo, varanda, tipo_varanda, tamanho, status)
VALUES
(2, 0, 3, 'Comum', 'SEM', 'Não se aplica', 'Pequeno', 'Disponível'), 
(5, 0, 2, 'Comum', 'SEM', 'Não se aplica', 'Pequeno', 'Disponível'),
(101, 1, 2, 'Luxo', 'COM', 'Lateral', 'Médio', 'Disponível'),
(102, 1, 4, 'Luxo', 'COM', 'Lateral', 'Grande', 'Disponível'), 
(203, 2, 3, 'Comum', 'COM', 'Frente Mar', 'Pequeno', 'Disponível'),
(208, 2, 2, 'Luxo', 'COM', 'Frente Mar', 'Grande', 'Disponível'), 
(301, 0, 2, 'Comum', 'COM', 'Lateral', 'Pequeno', 'Disponível'), 
(305, 3, 2, 'Luxo', 'COM', 'Lateral', 'Médio', 'Disponível'); 

UPDATE quartos
SET tipo = 'Comum'
WHERE id = 3;
 
UPDATE quartos
SET capacidade = 2, tipo = 'Comum', tamanho = 'Médio'
WHERE id = 4;

UPDATE quartos
SET tipo_varanda = 'Lateral', tamanho = 'Médio'
WHERE id = 5;

UPDATE quartos
SET andar = 3, capacidade = 5, varanda = 'SEM', tipo_varanda = 'Não se aplica', tamanho = 'Extra Grande'
WHERE id = 7; 

UPDATE quartos
SET varanda = 'SEM', tipo_varanda = 'Não se aplica', tamanho = 'Extra Grande'
WHERE id = 8; 