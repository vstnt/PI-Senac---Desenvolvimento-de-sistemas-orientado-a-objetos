package pi.model;

public class Fornecedor extends PessoaJuridica {
    private String areaAtuacao;
    private String produtosServicos;
    private String registroInstitucional;

    public void cadastrarFornecedor() {
        // Stub de cadastro
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getProdutosServicos() {
        return produtosServicos;
    }

    public void setProdutosServicos(String produtosServicos) {
        this.produtosServicos = produtosServicos;
    }

    public String getRegistroInstitucional() {
        return registroInstitucional;
    }

    public void setRegistroInstitucional(String registroInstitucional) {
        this.registroInstitucional = registroInstitucional;
    }
}
