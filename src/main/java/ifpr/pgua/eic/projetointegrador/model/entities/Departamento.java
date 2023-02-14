package ifpr.pgua.eic.projetointegrador.model.entities;

public class Departamento {

    private Integer id;
    private String nome;
    private String responsavel;

    public Departamento(Integer id, String nome, String responsavel) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public Departamento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Departamento(String nome, String responsavel) {
        this.nome = nome;
        this.responsavel = responsavel;
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

}
