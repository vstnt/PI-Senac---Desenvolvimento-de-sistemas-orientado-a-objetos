package pi.model;

import java.time.LocalDate;

public class Aluno extends PessoaFisica {
    private String matricula;
    private String curso;
    private LocalDate dataIngresso;

    public void cadastrarAluno() {
        // Stub de cadastro
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
}
