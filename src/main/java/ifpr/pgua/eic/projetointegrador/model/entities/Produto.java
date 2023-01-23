package ifpr.pgua.eic.projetointegrador.model.entities;

import java.time.LocalDateTime;

public class Produto {
    
    private Integer id;
    private String nome;
    private String codigo;
    private Double valor;
    private LocalDateTime validade;
    private Long quantidade;
    
    public Produto(Integer id, String nome, String codigo, Double valor, LocalDateTime validade, Long quantidade) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.validade = validade;
        this.quantidade = quantidade;
    }

    public Produto(String nome, String codigo, Double valor, LocalDateTime validade, Long quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.validade = validade;
        this.quantidade = quantidade;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setData(LocalDateTime validade) {
        this.validade = validade;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
}
