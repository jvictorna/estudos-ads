USE planoalimentaraula09;

-- =========================================================
-- AULAS 11, 12 E 13 - FUNCIONALIDADES DO SELECT
-- Curso em Vídeo - Gustavo Guanabara
--
-- Conceitos praticados:
-- SELECT
-- ORDER BY
-- WHERE
-- BETWEEN
-- LIKE
-- NOT LIKE
-- DISTINCT
-- COUNT
-- MAX
-- MIN
-- AVG
-- SUM
-- GROUP BY
-- HAVING
--
-- Banco utilizado:
-- planoalimentaraula09
--
-- Observação:
-- Alguns campos nutricionais foram armazenados como VARCHAR
-- (ex.: '50g' e '22-24g'), o que limita operações matemáticas
-- com SUM() e AVG(). Em um sistema real seria mais adequado
-- utilizar tipos numéricos (INT ou DECIMAL).
-- =========================================================

-- SELECT básico: exibe todos os registros da tabela referencias
SELECT * 
FROM referencias;

-- SELECT com colunas específicas
SELECT alimento_porcao, proteina_sozinho
FROM referencias;

-- ORDER BY: ordena os alimentos em ordem alfabética
SELECT * 
FROM referencias
ORDER BY alimento_porcao;

-- SELECT básico na tabela resumo_do_dia_base
SELECT * 
FROM resumo_do_dia_base;

-- ORDER BY DESC: ordena os horários do mais tarde para o mais cedo
SELECT * 
FROM resumo_do_dia_base
ORDER BY horario DESC;

-- WHERE: filtra alimentos com proteína igual a 50g
SELECT * 
FROM referencias
WHERE proteina_sozinho = '50g';

-- WHERE com operador relacional: refeições após 16:00
SELECT * 
FROM resumo_do_dia_base
WHERE horario > '16:00:00';

-- BETWEEN: refeições entre 12:00 e 20:00
SELECT * 
FROM resumo_do_dia_base
WHERE horario BETWEEN '12:00:00' AND '20:00:00'
ORDER BY horario;

-- SELECT básico na tabela almoco
SELECT * 
FROM almoco;

-- LIKE: alimentos que começam com a letra F
SELECT * 
FROM almoco
WHERE alimento LIKE 'F%'
ORDER BY id;

-- SELECT básico na tabela quantidades_praticas
SELECT * 
FROM quantidades_praticas;

-- LIKE: alimentos que contêm a palavra frango
SELECT * 
FROM quantidades_praticas
WHERE alimento LIKE '%frango%'
ORDER BY id;

-- NOT LIKE: alimentos que não contêm a palavra frango
SELECT * 
FROM referencias
WHERE alimento_porcao NOT LIKE '%frango%'
ORDER BY alimento_porcao;

-- NOT LIKE selecionando colunas específicas
SELECT alimento_porcao, proteina_sozinho, proteina_combinada
FROM referencias
WHERE alimento_porcao NOT LIKE '%frango%'
ORDER BY alimento_porcao;

-- SELECT simples para visualizar os valores da coluna proteina_sozinho
SELECT proteina_sozinho
FROM referencias;

-- DISTINCT: exibe valores únicos da coluna proteina_sozinho
SELECT DISTINCT proteina_sozinho
FROM referencias;

-- SELECT com colunas específicas
SELECT id, alimento_porcao
FROM referencias;

-- COUNT: conta quantos alimentos existem na tabela referencias
SELECT COUNT(alimento_porcao)
FROM referencias;

-- COUNT + LIKE: conta alimentos que contêm a palavra frango
SELECT COUNT(alimento_porcao)
FROM referencias
WHERE alimento_porcao LIKE '%frango%';

-- DESCRIBE: exibe a estrutura da tabela resumo_do_dia_base
DESCRIBE resumo_do_dia_base;

-- DESCRIBE: exibe a estrutura da tabela quantidades_praticas
DESCRIBE quantidades_praticas;

-- Visualização da coluna proteina
SELECT proteina
FROM resumo_do_dia_base;

-- Observação:
-- A coluna proteina foi armazenada como VARCHAR, com valores como '4g', '54g' e '59g'.
-- Por isso, SUM() não é adequado para cálculos precisos nesse campo.
-- Em um sistema real, o ideal seria armazenar o valor numérico em uma coluna DECIMAL ou INT
-- e deixar a unidade de medida para a camada de apresentação.
SELECT SUM(proteina)
FROM resumo_do_dia_base;

-- Observação:
-- A coluna meta_proteina também foi armazenada como VARCHAR, com valores como '30-50g'.
-- Por isso, SUM() não é adequado para cálculos numéricos reais nesse formato.
SELECT SUM(meta_proteina)
FROM quantidades_praticas;

-- MAX: maior horário cadastrado no resumo do dia
SELECT MAX(horario)
FROM resumo_do_dia_base;

-- MIN: menor horário cadastrado no resumo do dia
SELECT MIN(horario)
FROM resumo_do_dia_base;

-- Observação:
-- AVG() também fica limitado em campos armazenados como VARCHAR.
-- Para médias reais, o valor deveria ser armazenado em formato numérico.
SELECT AVG(meta_proteina)
FROM quantidades_praticas;

-- Observação:
-- Mesmo caso da consulta anterior: proteina está como VARCHAR.
SELECT AVG(proteina)
FROM resumo_do_dia_base;

-- GROUP BY: agrupa valores iguais de proteina_sozinho
SELECT proteina_sozinho
FROM referencias
GROUP BY proteina_sozinho;

-- GROUP BY + COUNT: conta quantas vezes cada proteína aparece
SELECT proteina_sozinho, COUNT(proteina_sozinho)
FROM referencias
GROUP BY proteina_sozinho;

-- HAVING: exibe apenas proteínas que aparecem mais de uma vez
SELECT proteina_sozinho, COUNT(*)
FROM referencias
GROUP BY proteina_sozinho
HAVING COUNT(*) > 1;

-- WHERE + LIKE + ORDER BY: alimentos que contêm a palavra ovo
SELECT *
FROM referencias
WHERE alimento_porcao LIKE '%ovo%'
ORDER BY alimento_porcao;

-- BETWEEN + ORDER BY: refeições entre 06:00 e 18:00 ordenadas por horário
SELECT *
FROM resumo_do_dia_base
WHERE horario BETWEEN '06:00:00' AND '18:00:00'
ORDER BY horario;