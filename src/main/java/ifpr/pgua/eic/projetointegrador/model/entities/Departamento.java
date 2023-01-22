package ifpr.pgua.eic.projetointegrador.model.entities;

import java.util.List;

public class Departamento {
    
    private Integer id;
    private String nome;
    private String responsavel;
    private List<Produto> produtos;
    
    public Departamento(Integer id, String nome, String responsavel, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
        this.produtos = produtos;
    }

    public Departamento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    

    
}
