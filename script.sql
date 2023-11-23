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







