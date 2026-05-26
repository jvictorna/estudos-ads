USE planoalimentaraula09; 

SHOW tables;

INSERT INTO pre_treino 
(alimento, proteina, obs) 
VALUES
('Banana (1 unidade)', '1g', 'Energia rápida'), 
('Aveia (30g)', '3g', 'Carbo complexo'),
('Café', ' - ', 'Foco e disposição'); 

INSERT INTO cafe_principal
(alimento, proteina, obs)
VALUES
('3 ovos', '18g', 'Proteína completa'), 
('1 scoop whey', '22-24g', 'Absorção rápida'),
('200ml leite', '6g', 'Cálcio + proteína'),
('2 fatias pão integral', '6g', 'Carbo + fibras'); 

INSERT INTO almoco
(alimento, proteina, obs)
VALUES
('180g frango grelhado', '50g', 'Proteína principal'),
('1 concha feijão', '5g', 'Proteína vegetal'), 
('150g arroz cozido', '4g', 'Carbo base'),
('Salada / Legumes', ' - ', 'Fibras e saciedade'); 

INSERT INTO lanche_trabalho
(alimento, proteina, obs)
VALUES
('80g frango desfiado', '22g', 'Proteína prática'),
('1 fatia queijo', '4g', 'Complemento'),
('2 fatias pão integral', '6g', 'Carbo'), 
('- OU whey + banana - ', '25g', 'Opção B'); 

INSERT INTO refeicao_trabalho 
(alimento, proteina, obs)
VALUES
('100g carne moída', '26g', 'Proteína densa'), 
('2 ovos', '12g', 'Complemento'),
('150g macaxeira/batata', ' - ', 'Carbo base'); 

INSERT INTO ceia
(alimento, proteina, obs)
VALUES
('Iogurte natural (200g)', '10g', 'Caseína (absorção lenta)'),
('Aveia (20g)', '3g', 'Fibras'),
(' - OU 2 ovos -', '12g', 'Opção B'); 

INSERT INTO variacoes_quinta_feira
(semana, proteina_especial, quantidade, proteina_estimada)
VALUES
('Semana 1', 'Atum em lata', '2 latas (170g)', '40g'),
('Semana 2', 'Sardinha em lata', '2 latas (125g)', '35g'),
('Semana 3', 'Tilápia grelhada', '200g', '44g'),
('Semana 4', 'Fígado bovino', '180g', '47g'); 

INSERT INTO resumo_do_dia_base
(refeicao, horario, proteina)
VALUES
('Pré-treino', '06:40', '4g'),
('Pós-treino / Café', '09:00', '54g'),
('Almoço (frango)', '12:30', '59g'),
('Lanche', '16:30', '28g'),
('Janta', '20:00', '38g'),
('Ceia', '23:00', '12g'); 

INSERT INTO semana1
(alimento, proteina, obs)
VALUES
('2 latas atum', '40g', 'Já vem pronto, zero preparo'),
('1 concha feijão', '5g', 'Proteína vegetal'),
('150g arroz cozido', '4g', 'Carbo base'); 

INSERT INTO semana2
(alimento, proteina, obs)
VALUES
('2 latas sardinha (125g)', '35g', 'Rica em ômega-3'),
('1 concha feijão', '5g', 'Proteína vegetal'),
('150g arroz cozido', '4g', 'Carbo base'); 

INSERT INTO semana3
(alimento, proteina, obs)
VALUES
('200g tilápia grelhada', '44g', 'Peixe magro e neutro'),
('1 concha feijão', '5g', 'Proteína vegetal'),
('150g arroz cozido', '4g', 'Carbo base'); 

INSERT INTO semana4
(alimento, proteina, obs)
VALUES
('180g fígado bovino', '47g', 'Rico em ferro e vitaminas'),
('1 concha feijão', '5g', 'Proteína vegetal'),
('150g arroz cozido', '4g', 'Carbo base');

INSERT INTO referencias
(alimento, proteina_sozinho, combinacao_sugerida, proteina_combinada)
VALUES
('Frango grelhado (180g)', '50g', 'Arroz 150g + Feijão', '59g'),
('Carne moída (200g)', '52g', '2 Ovos', '64g'),
('Atum em lata (2 latas)', '40g', 'Arroz + Feijão', '49g'),
('Sardinha em lata (2 latas)', '35g', 'Arroz + Feijão', '44g'),
('Tilápia grelhada (200g)', '44g', 'Arroz + Feijão', '53g'),
('Fígado bovino (180g)', '47g', 'Arroz + Feijão', '56g'),
('Ovo (1 unidade)', '6g', '3 Ovos + Queijo', '22g'),
('Whey protein (1 scoop)', '22-24g', 'Whey + 200ml Leite', '28-30g'),
('Leite integral (200ml)', '6g', 'Leite + Aveia (30g)', '9g'),
('Pão integral (2 fatias)', '6g', 'Pão + Frango (80g)', '28g'),
('Feijão (1 concha M)', '5g', 'Feijão + Arroz', '9g'),
('Iogurte natural (200g)', '10g', 'Iogurte + Aveia', '13g'),
('Queijo mussarela (1 fatia)', '4g', 'Queijo + 2 Ovos', '16g'),
('Aveia (30g)', '3g', 'Aveia + Iogurte', '13g');

INSERT INTO praticas_referencias
(alimento, quantidade_base, meta_proteina)
VALUES
('Frango grelhado', '150-200g (cozido)', '30-50g'),
('Carne moída', '150-200g (cozida)', '35-52g'),
('Tilápia grelhada', '180-200g', '38-44g'),
('Fígado bovino', '150-180g', '38-47g'),
('Atum em lata', '2 latas (170g)', '40g'),
('Sardinha em lata', '2 latas (125g)', '35g'),
('Ovos', '3-4 unidades', '18-24g'),
('Arroz cozido', '120-180g', '3-5g (carbo)'),
('Feijão', '1 concha M', '5g'),
('Aveia', '20-40g', '2-4g'),
('Pão integral', '2 fatias', '5-7g'),
('Whey protein', '1 scoop (30g)', '22-24g');
 
