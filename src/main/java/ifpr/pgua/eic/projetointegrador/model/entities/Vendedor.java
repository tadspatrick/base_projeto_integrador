package ifpr.pgua.eic.projetointegrador.model.entities;

public class Vendedor {
    
    private int id;
    private String nome;
    private String prontuario;
    private String email;
    private String senha;
    
    public Vendedor(int id, String nome, String prontuario, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.prontuario = prontuario;
        this.email = email;
        this.senha = senha;
    }

    public Vendedor(int id, String nome, String prontuario) {
        this.id = id;
        this.nome = nome;
        this.prontuario = prontuario;
    }

    public Vendedor(String nome, String prontuario, String email, String senha) {
        this.nome = nome;
        this.prontuario = prontuario;
        this.email = email;
        this.senha = senha;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
      
}
