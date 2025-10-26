package pi.model;

public class Professor extends PessoaFisica {
    private String areaAtuacao;
    private String titulacao;
    private String registroInstitucional;

    public void cadastrarProfessor() {
        // Stub de cadastro
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getRegistroInstitucional() {
        return registroInstitucional;
    }

    public void setRegistroInstitucional(String registroInstitucional) {
        this.registroInstitucional = registroInstitucional;
    }
}
