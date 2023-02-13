CREATE TABLE IF NOT EXISTS vendedores(
    id INT AUTO_INCREMENT, 
    nome VARCHAR(255) NOT NULL, 
    prontuario VARCHAR(255) NOT NULL, 
    email VARCHAR(255) NOT NULL, 
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS departamentos(
    id INT AUTO_INCREMENT, 
    nome VARCHAR(255) NOT NULL, 
    responsavel VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS produtos(
    id INT AUTO_INCREMENT, 
    nome VARCHAR(255) NOT NULL, 
    codigo VARCHAR(255) NOT NULL,
    valor DOUBLE NOT NULL, 
    validade DATE, 
    quantidade BIGINT,
    id_departamento INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_departamento) REFERENCES departamentos(id)
);