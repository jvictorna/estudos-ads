create database aula14e15e16_relacionamentos
default character set utf8mb4
default collate utf8mb4_general_ci;

use aula14e15e16_relacionamentos;

create table status (
id_status int not null auto_increment,
descricao varchar(50) not null,
primary key (id_status) 
) default charset utf8mb4;

create table tipo_quarto (
id_tipo int not null auto_increment,
descricao varchar(70) not null,
primary key (id_tipo)
) default charset utf8mb4;

create table modelo_quarto (
id_modelo int not null auto_increment,
descricao varchar(70) not null,
tem_hidromassagem boolean not null,
primary key (id_modelo)
) default charset utf8mb4;

create table quartos (
id_quarto int not null auto_increment,
numero varchar(10) not null unique,
andar int not null,
tamanho varchar(5) not null,  
primary key (id_quarto)
) default charset utf8mb4;

show tables;

select * from modelo_quarto;

describe modelo_quarto;

alter table quartos
add column id_status int not null;

alter table quartos
add column id_tipo int not null; 

alter table quartos
add column id_modelo int not null;

alter table quartos
add column id_status_anterior int;

alter table quartos
add constraint fk_quarto_status
foreign key (id_status)
references status(id_status);

alter table quartos
add constraint fk_quarto_tipo
foreign key (id_tipo)
references tipo_quarto(id_tipo);

alter table quartos
add constraint fk_quarto_modelo
foreign key (id_modelo)
references modelo_quarto(id_modelo);

alter table quartos
add constraint fk_quarto_status_anterior
foreign key (id_status_anterior)
references status(id_status);

describe quartos;

show create table quartos;

insert into status (descricao) values
('Disponível'),
('Ocupado'),
('Sujo'),
('Em limpeza'),
('Manutenção');

insert into tipo_quarto (descricao) values
('Casal'),
('Triplo'),
('Quádruplo'),
('Quíntuplo');

insert into modelo_quarto (descricao, tem_hidromassagem) values
('Standard Sem Varanda', false),
('Varanda Lateral', false),
('Varanda Frente Mar', false),
('Luxo Sem Varanda', true),
('Luxo com Varanda Frente Mar', true);

select * from status;

select * from tipo_quarto;

select * from modelo_quarto;

insert into quartos
(numero, andar, tamanho, id_status, id_tipo, id_modelo, id_status_anterior)
values
('02', 0, 'P', 1, 2, 1, NULL),
('03', 0, 'P', 1, 2, 1, NULL),
('04', 0, 'P', 1, 2, 1, NULL),
('05', 0, 'P', 1, 2, 1, NULL),
('101', 1, 'M', 1, 1, 2, NULL),
('102', 1, 'M', 1, 1, 2, NULL),
('103', 1, 'M', 1, 1, 2, NULL),
('104', 1, 'M', 1, 1, 2, NULL),
('105', 1, 'M', 1, 1, 2, NULL),
('106', 1, 'M', 1, 1, 2, NULL),
('107', 1, 'M', 1, 1, 2, NULL),
('108', 1, 'M', 1, 1, 3, NULL),
('109', 1, 'M', 1, 1, 3, NULL),
('110', 1, 'GG', 1, 4, 1, NULL),
('111', 1, 'GG', 1, 3, 1, NULL),
('112', 1, 'GG', 1, 3, 1, NULL),
('201', 2, 'M', 1, 1, 2, NULL),
('202', 2, 'M', 1, 1, 2, NULL),
('203', 2, 'M', 1, 2, 2, NULL),
('204', 2, 'M', 1, 2, 2, NULL),
('205', 2, 'M', 1, 2, 2, NULL),
('206', 2, 'M', 1, 2, 2, NULL),
('207', 2, 'M', 1, 2, 2, NULL),
('208', 2, 'G', 1, 1, 5, NULL),
('209', 2, 'GG', 1, 3, 1, NULL),
('210', 2, 'GG', 1, 4, 1, NULL),
('211', 2, 'GG', 1, 3, 1, NULL),
('301', 3, 'GG', 1, 4, 1, NULL),
('302', 3, 'P', 1, 2, 1, NULL),
('303', 3, 'P', 1, 1, 1, NULL),
('304', 3, 'P', 1, 1, 1, NULL),
('305', 3, 'G', 1, 1, 4, NULL),
('306', 3, 'P', 1, 1, 1, NULL),
('307', 3, 'M', 1, 2, 3, NULL),
('308', 3, 'M', 1, 2, 3, NULL),
('309', 3, 'GG', 1, 3, 1, NULL),
('310', 3, 'GG', 1, 3, 1, NULL),
('311', 3, 'GG', 1, 4, 1, NULL);

select count(*) from quartos;

select * from quartos
order by numero;

select q.numero, q.andar, q.tamanho, s.descricao, t.descricao, m.descricao
from quartos q, status s, tipo_quarto t, modelo_quarto m
where q.id_status = s.id_status
and q.id_tipo = t.id_tipo
and q.id_modelo = m.id_modelo
order by numero;

select t.descricao, COUNT(*)
from quartos q
join tipo_quarto t
on q.id_tipo = t.id_tipo
group by t.descricao;

select count(*)
from quartos q
join modelo_quarto m
on q.id_modelo = m.id_modelo
where m.tem_hidromassagem = true;

select q.numero
from quartos q
join modelo_quarto m
on q.id_modelo = m.id_modelo
where m.descricao like '%Frente Mar%';

select q.numero
from quartos q
join modelo_quarto m
on q.id_modelo = m.id_modelo
where m.descricao like '%Varanda Lateral%';

select q.numero
from quartos q
join modelo_quarto m
on q.id_modelo = m.id_modelo
where m.descricao like '%Standard Sem Varanda%';