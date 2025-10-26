package pi.model;

public class Pessoa {
    private Long id;
    private String email;
    private String telefone;

    public boolean validarDados() {
        return email != null && email.contains("@");
    }

    public void atualizarCadastro(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public void excluirCadastro() {
        // Em uma aplicação real, removeria do repositório/BD.
        this.id = null;
        this.email = null;
        this.telefone = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
