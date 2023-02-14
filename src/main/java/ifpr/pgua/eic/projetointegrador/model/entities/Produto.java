package ifpr.pgua.eic.projetointegrador.model.entities;

public class Produto {

    private Integer id;
    private String nome;
    private String codigo;
    private Double valor;
    private String validade;
    private Long quantidade;
    private Integer id_departamento;

    public Produto(Integer id, String nome, String codigo, Double valor, String validade, Long quantidade,
            Integer id_departamento) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.validade = validade;
        this.quantidade = quantidade;
        this.id_departamento = id_departamento;
    }

    public Produto(String nome, String codigo, Double valor, String validade, Long quantidade,
            Integer id_departamento) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.validade = validade;
        this.quantidade = quantidade;
        this.id_departamento = id_departamento;
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

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

}
