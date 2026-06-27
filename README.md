# ☕ Java & MySQL — Estudos e Exercícios

Repositório com exercícios, práticas e projetos desenvolvidos durante minha formação prática em programação 
e banco de dados, com foco na construção de base técnica sólida e aplicação no desenvolvimento de um sistema 
autoral de governança hoteleira.

### Atualmente estudando:
- JDBC (Java Database Connectivity)
- Persistência de dados com Java e MariaDB
- Integração Java + Banco de Dados

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

## 🔌 JDBC

Exercícios organizados na pasta `JDBC/`

* Aula 01 — Configuração do ambiente JDBC, instalação do driver MariaDB e criação da primeira conexão entre Java e banco de dados.
* Aula 02 — Estrutura inicial da classe DAO (Data Access Object) para gerenciamento de conexões.
* Aula 03 — Testes de conexão utilizando MariaDB, DriverManager e objeto Connection.
* Aula 04 — CRUD Create utilizando JavaBeans, DAO, PreparedStatement e inserção de dados via console.
* Aula 05 — CRUD Read utilizando ResultSet, ArrayList<JavaBeans> e listagem dinâmica de registros do banco de dados.
* Aula 06 — CRUD Read individual utilizando SELECT, WHERE, ResultSet e retorno de objeto JavaBeans.
* Aula 07 — CRUD Update utilizando PreparedStatement, WHERE por ID e atualização de registros no banco de dados.
* Aula 08 — CRUD Delete utilizando PreparedStatement, WHERE por ID e exclusão de registros do banco de dados.
* Aula 09 — Geração de relatórios PDF utilizando a biblioteca iTextPDF e dados obtidos do banco de dados via JDBC.

Prática complementar desenvolvida utilizando:

* Java JDK 25
* Apache NetBeans IDE 29
* MariaDB Connector/J
* MariaDB (XAMPP)

Objetivos desta etapa:

* compreender o funcionamento do JDBC;
* estabelecer conexões entre aplicações Java e bancos de dados relacionais;
* preparar a futura integração do Hotel Governance System (HGS) com persistência de dados;
* aplicar conceitos de DAO, CRUD e consultas SQL através do Java.


### 🚀 Migração do Hotel Governance System (HGS)

Objetivo: substituir gradualmente a persistência em memória por persistência em banco de dados utilizando JDBC e MariaDB.

#### Fase 01 — Leitura de quartos via JDBC

- Criação da classe QuartoBean
- Implementação da conexão JDBC com MariaDB
- Criação do método listarQuartos()
- Leitura completa dos 38 quartos cadastrados
- Validação dos dados recebidos do banco de dados

#### Fase 02 — Exibição completa dos quartos via JDBC

- Implementação de consultas com INNER JOIN
- Integração entre as tabelas quartos, status, tipo_quarto e modelo_quarto
- Conversão dos IDs em descrições legíveis
- Exibição completa das informações dos quartos diretamente do banco de dados
- Validação da modelagem relacional do HGS
- Primeira leitura de dados já em formato amigável ao usuário

#### Fase 3 — Regras de negócio e fluxo operacional via JDBC

- Implementado sistema completo de inspeção (check-list) para quartos.
- Separação dos check-lists por categoria de quarto (Comum e Luxo).
- Criação da camada `service` para concentrar as regras de inspeção.
- Correção das regras de transição entre os estados do quarto.
- Implementado controle da origem da limpeza (`id_origem_limpeza`), 
garantindo que o sistema diferencie corretamente limpeza pós-checkout e arrumação de quartos ocupados.
- Correção das travas de segurança e atualização automática do estado dos quartos durante a execução do sistema.

#### Fase 04 — Manutenção Inteligente

- Refatoração completa do fluxo de manutenção — eliminação da decisão
  manual do técnico sobre o destino do quarto.
- Implementação do campo `id_origem_manutencao` no banco de dados,
  registrando automaticamente o status do quarto no momento do bloqueio.
- O sistema passa a consultar a origem da manutenção para determinar
  automaticamente o destino do quarto após a inspeção pós-manutenção:
  quartos que vieram de Ocupado ou Arrumação Pendente retornam para
  Ocupado; demais origens retornam para Disponível.
- Técnico responde apenas uma pergunta ao concluir a manutenção —
  o sistema decide o restante com base nos dados já registrados.
- Redefinição das travas de manutenção — bloqueio explícito dos status
  Em Limpeza (4), Em Manutenção (7), Manutenção Urgente (8) e
  Revisão Pós-Manutenção (9).
- Limpeza automática dos campos `id_origem_limpeza` e
  `id_origem_manutencao` ao liberar ou realizar check-in do quarto.
- Validação completa em bateria de testes cobrindo todos os fluxos
  de entrada e saída da manutenção.

#### Fase 05 — Controller

- Criação da classe HGSController concentrando todas as regras 
  de negócio e operações do sistema.
- Main reduzido à responsabilidade de UI — exibição, menu e 
  captura de entrada do usuário.
- Separação clara de responsabilidades: Menu → Controller → DAO.
- validarTrava() migrada para o Controller retornando int — 
  o main atualiza opcao com o retorno.
- getPosicao() centralizado no Controller eliminando lógica 
  duplicada de busca.


## 📁 Organização do Repositório

```text
java-estudos/
├── Java Basico/
├── Java POO/
├── MySQL/
└── JDBC/
```

## 📂 Como abrir os projetos

Cada aula está organizada em sua própria pasta dentro de `Java Basico/`, `Java POO/`, `MySQL/` ou `JDBC/`.

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

### Projetos JDBC

Os exercícios JDBC ficam organizados na pasta `JDBC/` e podem ser abertos diretamente no Apache NetBeans.