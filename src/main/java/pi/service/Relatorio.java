package pi.service;

import pi.model.Aluno;
import pi.model.Professor;
import pi.model.Fornecedor;

import java.util.List;
import java.util.stream.Collectors;

public class Relatorio {
    public String gerarRelatorioAlunos(List<Aluno> alunos) {
        String header = "Relatório de Alunos";
        String body = alunos.stream()
                .map(a -> String.format("Matricula: %s | Nome: %s | Curso: %s",
                        a.getMatricula(), a.getNome(), a.getCurso()))
                .collect(Collectors.joining(System.lineSeparator()));
        return header + System.lineSeparator() + body + System.lineSeparator();
    }

    public String gerarRelatorioProfessores(List<Professor> professores) {
        String header = "Relatório de Professores";
        String body = professores.stream()
                .map(p -> String.format("Nome: %s | Área: %s | Titulação: %s",
                        p.getNome(), p.getAreaAtuacao(), p.getTitulacao()))
                .collect(Collectors.joining(System.lineSeparator()));
        return header + System.lineSeparator() + body + System.lineSeparator();
    }

    public String gerarRelatorioFornecedores(List<Fornecedor> fornecedores) {
        String header = "Relatório de Fornecedores";
        String body = fornecedores.stream()
                .map(f -> String.format("Razão Social: %s | Área: %s",
                        f.getRazaoSocial(), f.getAreaAtuacao()))
                .collect(Collectors.joining(System.lineSeparator()));
        return header + System.lineSeparator() + body + System.lineSeparator();
    }
}
