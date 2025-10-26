package pi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.javalin.Javalin;
import pi.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class App {
    private static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());

    private static final List<Aluno> ALUNOS = new CopyOnWriteArrayList<>();
    private static final List<Professor> PROFESSORES = new CopyOnWriteArrayList<>();
    private static final List<Fornecedor> FORNECEDORES = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        seed();

        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "7000"));
        Javalin app = Javalin.create(config -> {
            config.http.defaultContentType = "application/json";
        }).start(port);

        app.get("/health", ctx -> ctx.result("ok"));

        // Alunos
        app.get("/alunos", ctx -> ctx.json(ALUNOS));
        app.get("/alunos/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            Aluno a = getById(ALUNOS, id);
            if (a == null) ctx.status(404).result("Aluno não encontrado");
            else ctx.json(a);
        });
        app.post("/alunos", ctx -> {
            try {
                Aluno a = MAPPER.readValue(ctx.body(), Aluno.class);
                if (a.getId() == null) a.setId(nextId());
                ALUNOS.add(a);
                ctx.status(201).json(a);
            } catch (Exception e) {
                ctx.status(400).result("JSON inválido: " + e.getMessage());
            }
        });
        app.put("/alunos/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            Aluno existente = getById(ALUNOS, id);
            if (existente == null) { ctx.status(404).result("Aluno não encontrado"); return; }
            try {
                Aluno a = MAPPER.readValue(ctx.body(), Aluno.class);
                a.setId(id);
                replaceById(ALUNOS, id, a);
                ctx.json(a);
            } catch (Exception e) {
                ctx.status(400).result("JSON inválido: " + e.getMessage());
            }
        });
        app.delete("/alunos/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            boolean removed = ALUNOS.removeIf(x -> idEquals(x.getId(), id));
            if (removed) ctx.status(204);
            else ctx.status(404).result("Aluno não encontrado");
        });

        // Professores
        app.get("/professores", ctx -> ctx.json(PROFESSORES));
        app.get("/professores/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            Professor p = getById(PROFESSORES, id);
            if (p == null) ctx.status(404).result("Professor não encontrado");
            else ctx.json(p);
        });
        app.post("/professores", ctx -> {
            try {
                Professor p = MAPPER.readValue(ctx.body(), Professor.class);
                if (p.getId() == null) p.setId(nextId());
                PROFESSORES.add(p);
                ctx.status(201).json(p);
            } catch (Exception e) {
                ctx.status(400).result("JSON inválido: " + e.getMessage());
            }
        });
        app.put("/professores/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            Professor existente = getById(PROFESSORES, id);
            if (existente == null) { ctx.status(404).result("Professor não encontrado"); return; }
            try {
                Professor p = MAPPER.readValue(ctx.body(), Professor.class);
                p.setId(id);
                replaceById(PROFESSORES, id, p);
                ctx.json(p);
            } catch (Exception e) {
                ctx.status(400).result("JSON inválido: " + e.getMessage());
            }
        });
        app.delete("/professores/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            boolean removed = PROFESSORES.removeIf(x -> idEquals(x.getId(), id));
            if (removed) ctx.status(204);
            else ctx.status(404).result("Professor não encontrado");
        });

        // Fornecedores
        app.get("/fornecedores", ctx -> ctx.json(FORNECEDORES));
        app.get("/fornecedores/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            Fornecedor f = getById(FORNECEDORES, id);
            if (f == null) ctx.status(404).result("Fornecedor não encontrado");
            else ctx.json(f);
        });
        app.post("/fornecedores", ctx -> {
            try {
                Fornecedor f = MAPPER.readValue(ctx.body(), Fornecedor.class);
                if (f.getId() == null) f.setId(nextId());
                FORNECEDORES.add(f);
                ctx.status(201).json(f);
            } catch (Exception e) {
                ctx.status(400).result("JSON inválido: " + e.getMessage());
            }
        });
        app.put("/fornecedores/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            Fornecedor existente = getById(FORNECEDORES, id);
            if (existente == null) { ctx.status(404).result("Fornecedor não encontrado"); return; }
            try {
                Fornecedor f = MAPPER.readValue(ctx.body(), Fornecedor.class);
                f.setId(id);
                replaceById(FORNECEDORES, id, f);
                ctx.json(f);
            } catch (Exception e) {
                ctx.status(400).result("JSON inválido: " + e.getMessage());
            }
        });
        app.delete("/fornecedores/{id}", ctx -> {
            long id = parseId(ctx.pathParam("id"));
            boolean removed = FORNECEDORES.removeIf(x -> idEquals(x.getId(), id));
            if (removed) ctx.status(204);
            else ctx.status(404).result("Fornecedor não encontrado");
        });

        System.out.println("API em execução na porta " + port + " (GET /health)");
    }

    private static long nextId() {
        return System.currentTimeMillis();
    }

    private static long parseId(String s) {
        try { return Long.parseLong(s); } catch (NumberFormatException e) { return -1; }
    }

    private static boolean idEquals(Long a, long b) { return a != null && a == b; }

    private static <T extends Pessoa> T getById(List<T> list, long id) {
        for (T t : list) {
            if (idEquals(t.getId(), id)) return t;
        }
        return null;
    }

    private static <T extends Pessoa> void replaceById(List<T> list, long id, T value) {
        for (int i = 0; i < list.size(); i++) {
            if (idEquals(list.get(i).getId(), id)) {
                list.set(i, value);
                return;
            }
        }
    }

    private static void seed() {
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setEmail("ana.silva@universidade.edu");
        aluno.setTelefone("11999990001");
        aluno.setNome("Ana Silva");
        aluno.setCpf("12345678901");
        aluno.setDataNascimento(LocalDate.of(2002, 5, 12));
        aluno.setMatricula("2025001");
        aluno.setCurso("Analise e Desenvolvimento de Sistemas");
        aluno.setDataIngresso(LocalDate.of(2023, 2, 1));
        ALUNOS.add(aluno);

        Professor professor = new Professor();
        professor.setId(2L);
        professor.setEmail("carlos.souza@universidade.edu");
        professor.setTelefone("11999990002");
        professor.setNome("Carlos Souza");
        professor.setCpf("98765432100");
        professor.setDataNascimento(LocalDate.of(1980, 11, 3));
        professor.setAreaAtuacao("Engenharia de Software");
        professor.setTitulacao("Mestrado");
        professor.setRegistroInstitucional("REG-PROF-1001");
        PROFESSORES.add(professor);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(3L);
        fornecedor.setEmail("contato@techsolutions.com.br");
        fornecedor.setTelefone("1133334444");
        fornecedor.setRazaoSocial("Tech Solutions Ltda");
        fornecedor.setNomeFantasia("TechSol");
        fornecedor.setCnpj("11222333000181");
        fornecedor.setAreaAtuacao("Tecnologia da Informação");
        fornecedor.setProdutosServicos("Equipamentos, manutenção e suporte");
        fornecedor.setRegistroInstitucional("REG-FORN-2001");
        FORNECEDORES.add(fornecedor);
    }
}
