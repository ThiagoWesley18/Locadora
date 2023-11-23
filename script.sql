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
                            CPF varchar(20) NOT NULL PRIMARY KEY,
                            Nome_completo VARCHAR(50),
                            idade INT
);

-- -----------------------------------------------------
-- Table LocadoraBD.tbl_aluguel
-- -----------------------------------------------------
CREATE TABLE tbl_aluguel(
                            Placa_Moto_Alugado	VARCHAR(20) NOT NULL UNIQUE,
                            CPF_cadastrado	VARCHAR(20),
                            Nome_Completo	VARCHAR(60),
                            idade	INT,
                            Data_de_Retirada	VARCHAR(20),
                            Data_de_Devolução	VARCHAR(20),
                            Opcionais	VARCHAR(200),
                            valor_total_pago	INT,
                            FOREIGN KEY (Placa_Moto_Alugado) REFERENCES motos (placa) ON DELETE CASCADE,
                            FOREIGN KEY (CPF_cadastrado) REFERENCES tbl_cliente (CPF) ON DELETE SET NULL
);


SHOW TABLES;







