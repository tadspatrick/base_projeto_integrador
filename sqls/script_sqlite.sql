CREATE TABLE IF NOT EXISTS vendedores(
    id INTEGER PRIMARY KEY, 
    nome TEXT NOT NULL, 
    prontuario TEXT NOT NULL, 
    email TEXT NOT NULL, 
    senha TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS produtos(
    id INTEGER PRIMARY KEY, 
    nome TEXT NOT NULL, 
    codigo TEXT NOT NULL,
    valor DOUBLE NOT NULL, 
    validade DATE NOT NULL, 
    quantidade SIGNED BIGINT NOT NULL,
    id_departamento FOREIGN KEY,
);

CREATE TABLE IF NOT EXISTS departamentos(
    id INTEGER PRIMARY KEY, 
    nome TEXT NOT NULL, 
    responsavel TEXT NOT NULL,
);