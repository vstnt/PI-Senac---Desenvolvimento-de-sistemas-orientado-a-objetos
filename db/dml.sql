-- Projeto Integrador - Entrega 2
-- DML com dados de exemplo para o modelo relacional

-- Pessoas base
INSERT INTO pessoa (email, telefone) VALUES
  ('ana.silva@universidade.edu', '11999990001'), -- id 1
  ('carlos.souza@universidade.edu', '11999990002'), -- id 2
  ('contato@techsolutions.com.br', '1133334444'); -- id 3

-- Pessoa Física (Ana e Carlos)
INSERT INTO pessoa_fisica (pessoa_id, nome, cpf, data_nascimento) VALUES
  (1, 'Ana Silva', '12345678901', DATE '2002-05-12'),
  (2, 'Carlos Souza', '98765432100', DATE '1980-11-03');

-- Pessoa Jurídica (Tech Solutions)
INSERT INTO pessoa_juridica (pessoa_id, razao_social, nome_fantasia, cnpj) VALUES
  (3, 'Tech Solutions Ltda', 'TechSol', '11222333000181');

-- Aluno (deriva da PF id 1)
INSERT INTO aluno (pessoa_id, matricula, curso, data_ingresso) VALUES
  (1, '2025001', 'Análise e Desenvolvimento de Sistemas', DATE '2023-02-01');

-- Professor (deriva da PF id 2)
INSERT INTO professor (pessoa_id, area_atuacao, titulacao, registro_institucional) VALUES
  (2, 'Engenharia de Software', 'Mestrado', 'REG-PROF-1001');

-- Fornecedor (deriva da PJ id 3)
INSERT INTO fornecedor (pessoa_id, area_atuacao, produtos_servicos, registro_institucional) VALUES
  (3, 'Tecnologia da Informação', 'Equipamentos, manutenção e suporte', 'REG-FORN-2001');

-- Exemplos de consultas úteis
-- Lista de alunos com dados pessoais
-- SELECT a.matricula, pf.nome, p.email, a.curso
--   FROM aluno a
--   JOIN pessoa_fisica pf ON pf.pessoa_id = a.pessoa_id
--   JOIN pessoa p ON p.id = pf.pessoa_id;

