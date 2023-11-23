# Sistema de Gestão de Locadora de Motos
## Descrição

Sistema com funcionalidaes de cadastro de motos, clientes, locações.  
As motos podem ser classificadas em:
- Economico
- Standard
- Premium 

Cada moto tem informações como:
- Placa
- Categoria
- Marca
- Dimensões
- Tipo de motor
- Capacidade do tanque
- Media de consumo
- Acessórios
- Valor da diária

Para alugar uma moto é necessário que o cliente esteja cadastrado no sistema.O aluguel pode ser feito com as seguintes informações:
- data de retirada
- data de devolução
- id do cliente
- placas das motos
- Opcionais

Funcionalidades:
- Controlar o estoque de motos
- Controlar o cadastro de clientes
- Alugar motos
- Verificar disponibilidade de motos
- Verificar disponibilidade de clientes

## Tecnologias
- Java 8
- MySQL  
para a criação do banco de dados, utilize o script abaixo:
```sql
CREATE DATABASE locadorabd;
CREATE USER 'user_locadora'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON locadorabd.* TO 'user_locadora'@'localhost' WITH GRANT OPTION;
SHOW DATABASES;
USE locadorabd;

-- -----------------------------------------------------
-- Schema LocadoraBD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table LocadoraBD.motos
-- -----------------------------------------------------
CREATE TABLE motos (
  placa VARCHAR(60) NOT NULL PRIMARY KEY UNIQUE,
  marca VARCHAR(60) NOT NULL,
  categoria VARCHAR(60) NOT NULL,
  acessorios VARCHAR(60) NOT NULL,
  tamanho VARCHAR(60) NOT NULL,
  tipo_de_motor VARCHAR(45) NOT NULL,
  tanque INT NOT NULL,
  consumo INT NOT NULL,
  custo INT NOT NULL);
  

-- -----------------------------------------------------
-- Table LocadoraBD.tbl_cliente
-- -----------------------------------------------------
CREATE TABLE tbl_cliente(
CPF varchar(20) not null primary key,
Nome_completo varchar(50),
idade int
);

-- -----------------------------------------------------
-- Table LocadoraBD.tbl_aluguel
-- -----------------------------------------------------
CREATE TABLE tbl_aluguel(
Placa_Moto_Alugado	varchar(20) NOT NULL UNIQUE,
CPF_cadastrado	varchar(20),
Nome_Completo	varchar(60),
idade	int,
Data_de_Retirada	varchar(20),
Data_de_Devolução	varchar(20),
Opcionais	varchar(200),
valor_total_pago	int,
FOREIGN KEY (Placa_Moto_Alugado) REFERENCES motos (placa) ON DELETE CASCADE,
FOREIGN KEY (CPF_cadastrado) REFERENCES tbl_cliente (CPF) ON DELETE SET NULL
);


SHOW TABLES;