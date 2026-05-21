use aula04;

insert into quartos
(numero, andar, tipo, status)
values
(05, 0, 'Casal sem varanda', 'Disponível'),
(101, 1, 'Casal com varanda lateral', 'Disponível'),
(201, 2, 'Casal com varanda lateral', 'Disponível'),
(307, 3, 'Casal com varanda frente mar', 'Disponível'),
(310, 3, 'Quádruplo sem varanda', 'Disponível'); 

select * from quartos;