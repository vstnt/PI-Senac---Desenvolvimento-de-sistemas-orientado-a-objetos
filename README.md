# PI - Desenvolvimento de Sistemas Orientado a Objetos

Projeto Integrador (fase 2): prototipação do backend em Java e do modelo relacional conforme a modelagem da fase 1.

## Anexar protótipos do figma

## Inserir os diagramas que foram criados na fase 1.

## Backend e estrutura do banco de dados
O sistema usa um modelo relacional com tabelas para `pessoa`, `pessoa_fisica`, `pessoa_juridica`, `aluno`, `professor` e `fornecedor`.

### Estrutura
- `db/ddl.sql` definição do banco de dados (DDL)
- `db/dml.sql` dados de exemplo (DML)
- `pom.xml` projeto Maven do backend
- `src/main/java/br/senac/pi` classes do domínio e `App` de demonstração

### Requisitos
- JDK 17+
- Maven 3.9+ (ou compatível)

### Executar o backend (API Javalin)
1) Compilar e empacotar (gera fat-jar com dependências)
   - `mvn -q -DskipTests package`
2) Executar o servidor
   - `java -jar target/pi-backend-1.0.0-shaded.jar`
   - Porta padrão: `7000` (altere com `PORT=8080`)

Endpoints (em memória):
- `GET /health` → ok
- Alunos: `GET /alunos`, `GET /alunos/{id}`, `POST /alunos`, `PUT /alunos/{id}`, `DELETE /alunos/{id}`
- Professores: `GET /professores`, `GET /professores/{id}`, `POST /professores`, `PUT /professores/{id}`, `DELETE /professores/{id}`
- Fornecedores: `GET /fornecedores`, `GET /fornecedores/{id}`, `POST /fornecedores`, `PUT /fornecedores/{id}`, `DELETE /fornecedores/{id}`

Exemplo de POST:
`curl -X POST http://localhost:7000/alunos -H "Content-Type: application/json" -d '{"id":10,"email":"a@b.com","telefone":"123","nome":"Fulano","cpf":"00000000000","curso":"ADS"}'`

### Dá pra testar com Postman:
- Importe a coleção: `postman/PI-API.postman_collection.json`
- Importe o ambiente: `postman/PI-Local.postman_environment.json`
- Selecione o ambiente “PI Local” e rode as requisições.

### Banco de dados
Aplicação dos scripts (PostgreSQL compatível):
- Criar estrutura: `db/ddl.sql`
- Popular dados: `db/dml.sql`


### Sistema de Gestão Acadêmica – Wireframes Figma

## 1. Área de Login
- Título: Área de Login
  - Formulário:
  - Nome do Usuário (input)
  - Senha (input)
  - Permanecer conectado (label)
  - Esqueci minha senha (link)
- Botões:
  - [Conectar]

---

## 1.2 Recuperar Senha
- Título: Recuperar Senha
  - Formulário:
  - Nome do Usuário (input)
  - E-mail cadastrado (input)
- Botões:
  - [Voltar]
  - [Confirmar]

---


## 2. Tela secretaria acadêmica

### 2.1 Cadastro Alunos
- Título: Cadastro
- Formulário:	
  - Tipo (label)
  - Nome (input)
  - CPF (input)
  - Matricula (input)
  - Curso (input)
- Botões:
  - [Voltar]
  - [Confirmar]
  - [Ajustar]

---

### 2.2 Cadastro Professor
- Título: Cadastro
- Formulário:	
  - Tipo (label)
  - Nome (input)
  - CPF (input)
  - Matricula (input)
  - Disciplina (input)
- Botões:
  - [Voltar]
  - [Confirmar]
  - [Ajustar]

---

## 3. Tela Administrador

### 3.1 Cadastro Alunos
- Título: Cadastro
- Formulário:	
  - Tipo (label)
  - Nome (input)
  - CPF (input)
  - Matricula (input)
  - Curso (input)
- Botões:
  - [Voltar]
  - [Confirmar]
  - [Ajustar]

---

### 3.2 Cadastro Professor
- Título: Cadastro
- Formulário:	
  - Tipo (label)
  - Nome (input)
  - CPF (input)
  - Matricula (input)
  - Disciplina (input)
- Botões:
  - [Voltar]
  - [Confirmar]
  - [Ajustar]

---

### 3.2 Cadastro Fornecedor
- Título: Cadastro
- Formulário:	
  - Tipo (label)
  - Razão Social (input)
  - CNPJ (input)
  - Endereço (input)
  - Telefone (input)
- Botões:
  - [Voltar]
  - [Confirmar]
  - [Ajustar]






