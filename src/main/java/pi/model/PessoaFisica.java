package pi.model;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public void cadastrarPessoaFisica() {
        // Stub de cadastro (ex.: persistir em um repositório)
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
