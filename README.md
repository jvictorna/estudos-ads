# ☕ Java & MySQL — Estudos e Exercícios

Repositório com exercícios, práticas e projetos desenvolvidos durante minha formação prática em programação 
e banco de dados, com foco na construção de base técnica sólida e aplicação no desenvolvimento de um sistema 
autoral de governança hoteleira.

### Atualmente estudando:
- Java Básico
- Programação Orientada a Objetos (POO)
- MySQL

Baseado nos cursos do professor Gustavo Guanabara — Curso em Vídeo.

---

## 🛠️ Ferramentas

### Desenvolvimento
- Java JDK 25
- Apache NetBeans IDE 29
- Git/GitHub

### Banco de Dados e Ambiente Local
- MySQL Workbench 8.0
- MySQL Server
- XAMPP

---

## 📚 Java Básico

Exercícios organizados na pasta `Java Basico/`

* Aula 04 — Primeiro programa, estrutura básica e System.out.println
* Aula 06 — Tipos primitivos, manipulação de dados, vetores e entrada com Scanner
* Aula 07 — Operadores aritméticos, operadores unários e classe Math aplicados ao projeto de governança
* Aula 08 — Operadores ternário, relacionais e lógicos aplicados ao projeto de governança
* Aula 09 e 10 — Estruturas condicionais (if/else, else if, switch/case) aplicadas ao projeto de governança
* Aula 11 — Estruturas de repetição com while (break e continue) aplicadas ao projeto de governança
* Aula 12 e 13 — Estruturas de repetição (do/while e for) aplicadas ao projeto de governança
* Aula 14 e 15 — Vetores, Arrays.fill e métodos com e sem retorno aplicados ao projeto de governança

---

## 🎯 Java POO

Exercícios organizados na pasta `Java POO/`

* Aula 02 — Classes e objetos aplicados ao projeto de governança
* Aulas 03 e 04 — Visibilidade, getters, setters e construtor aplicados ao projeto de governança
* Aulas 03 e 04 (complementar) — Setters com validação e construtor seguro aplicados ao projeto de governança
* Aula 03 e 04 (complementar 2) — Sistema bancário interativo com menu, Scanner e encapsulamento
* Aula 06 — Encapsulamento com interface aplicado ao projeto de governança
* Aulas 07 e 08 — Relacionamento entre classes: Quarto e CheckList aplicados ao projeto de governança
* Aulas 10 e 11 — Herança: classe abstrata Quarto, QuartoComum e QuartoLuxo aplicados ao projeto de governança
* Aulas 12 e 13 — Polimorfismo com sobreposição e sobrecarga aplicado ao projeto de governança

---

## 🗄️ MySQL

Exercícios organizados na pasta `MySQL/`

* Aula 03 — Criação do primeiro banco de dados com `CREATE DATABASE`
* Aula 04 — Criação da primeira tabela com `CREATE TABLE`, `PRIMARY KEY`, `AUTO_INCREMENT`, `NOT NULL` e configuração `UTF8`
* Aula 05 — Inserção e consulta de dados com `INSERT INTO` e `SELECT` aplicados à tabela de quartos
* Aula 06 — Alteração de estrutura da tabela com `ALTER TABLE`, `ADD COLUMN` e `UNIQUE`
* Aula 07 — Manipulação de dados com `TRUNCATE`, `INSERT INTO`, `UPDATE`, `WHERE` e `SELECT`
* Aula 09 e 10 — phpMyAdmin e prática complementar
* Aula 11, 12 e 13 — Consultas com `SELECT`, `ORDER BY`, `WHERE`, `BETWEEN`, `LIKE`, `DISTINCT`, `COUNT`, `MAX`, `MIN`, `AVG`, `SUM`, `GROUP BY` e `HAVING` aplicadas ao banco planoalimentaraula09
* Aula 14, 15 e 16 — Modelagem relacional, cardinalidade, chaves estrangeiras (`FOREIGN KEY`) e consultas com `INNER JOIN` aplicadas à modelagem inicial do banco de dados do Hotel Governance System (HGS)

Prática complementar desenvolvida utilizando:
- phpMyAdmin
- MySQL Workbench
- MariaDB Console

A atividade consistiu na criação de um banco de dados voltado para planejamento alimentar, com foco em:
- modelagem de tabelas;
- manipulação de dados;
- prática de comandos SQL;
- utilização de múltiplos ambientes de administração MySQL;
- debugging e correção de erros comuns.

📁 Diretório:
`Aula09e10-phpMyAdmin/`

---

## 📁 Organização do Repositório

```text
java-estudos/
├── Java Basico/
├── Java POO/
└── MySQL/
```

## 📂 Como abrir os projetos

Cada aula está organizada em sua própria pasta dentro de `Java Basico/` ou `Java POO/`.

Para abrir no NetBeans: **File → Open Project → selecione a pasta da aula desejada**

O código fonte de cada exercício fica em:

```text
NomeDaPasta
 └── src
      └── nomedoprojeto
           └── NomeDoProjeto.java
```

### Arquivos SQL

Os scripts `.sql` ficam organizados na pasta `MySQL/` e podem ser:
- executados no MySQL Workbench
- abertos em qualquer editor de texto ou IDE