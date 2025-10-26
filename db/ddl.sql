-- Projeto Integrador - Entrega 2
-- DDL do modelo relacional baseado no diagrama de classes
-- Alvo: SQL padrão (compatível com PostgreSQL)

-- Limpeza para reaplicar o script com segurança em ambientes de desenvolvimento
DROP TABLE IF EXISTS fornecedor CASCADE;
DROP TABLE IF EXISTS professor CASCADE;
DROP TABLE IF EXISTS aluno CASCADE;
DROP TABLE IF EXISTS pessoa_juridica CASCADE;
DROP TABLE IF EXISTS pessoa_fisica CASCADE;
DROP TABLE IF EXISTS pessoa CASCADE;

-- Tabela base
CREATE TABLE pessoa (
    id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email           VARCHAR(255) NOT NULL,
    telefone        VARCHAR(30)
);

-- Especialização: Pessoa Física (1:1 com pessoa)
CREATE TABLE pessoa_fisica (
    pessoa_id       BIGINT PRIMARY KEY,
    nome            VARCHAR(255) NOT NULL,
    cpf             VARCHAR(11) NOT NULL UNIQUE,
    data_nascimento DATE,
    CONSTRAINT fk_pf_pessoa FOREIGN KEY (pessoa_id)
        REFERENCES pessoa (id) ON DELETE CASCADE
);

-- Especialização: Pessoa Jurídica (1:1 com pessoa)
CREATE TABLE pessoa_juridica (
    pessoa_id     BIGINT PRIMARY KEY,
    razao_social  VARCHAR(255) NOT NULL,
    nome_fantasia VARCHAR(255),
    cnpj          VARCHAR(14) NOT NULL UNIQUE,
    CONSTRAINT fk_pj_pessoa FOREIGN KEY (pessoa_id)
        REFERENCES pessoa (id) ON DELETE CASCADE
);

-- Aluno (especialização de Pessoa Física)
CREATE TABLE aluno (
    pessoa_id      BIGINT PRIMARY KEY,
    matricula      VARCHAR(20) NOT NULL UNIQUE,
    curso          VARCHAR(150) NOT NULL,
    data_ingresso  DATE,
    CONSTRAINT fk_aluno_pf FOREIGN KEY (pessoa_id)
        REFERENCES pessoa_fisica (pessoa_id) ON DELETE CASCADE
);

-- Professor (especialização de Pessoa Física)
CREATE TABLE professor (
    pessoa_id              BIGINT PRIMARY KEY,
    area_atuacao           VARCHAR(150) NOT NULL,
    titulacao              VARCHAR(100),
    registro_institucional VARCHAR(50) UNIQUE,
    CONSTRAINT fk_prof_pf FOREIGN KEY (pessoa_id)
        REFERENCES pessoa_fisica (pessoa_id) ON DELETE CASCADE
);

-- Fornecedor (especialização de Pessoa Jurídica)
CREATE TABLE fornecedor (
    pessoa_id              BIGINT PRIMARY KEY,
    area_atuacao           VARCHAR(150) NOT NULL,
    produtos_servicos      TEXT,
    registro_institucional VARCHAR(50) UNIQUE,
    CONSTRAINT fk_forn_pj FOREIGN KEY (pessoa_id)
        REFERENCES pessoa_juridica (pessoa_id) ON DELETE CASCADE
);

-- Índices auxiliares (consulta por nome/razao_social)
CREATE INDEX idx_pf_nome ON pessoa_fisica (nome);
CREATE INDEX idx_pj_razao ON pessoa_juridica (razao_social);

