package objeto;


import java.sql.Date;


public class Cliente {
    
    private int ID;
    private String nome;
    private String CPF;
    private String email;
    private Date Nascimento;
    private String Sexo;
    private String senha;

    public Cliente() {
    }

    public Cliente(int ID, String nome, String CPF, String Email, Date Nascimento, String Sexo, String senha) {
        this.ID = ID;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.Nascimento = Nascimento;
        this.Sexo = Sexo;
        this.senha = senha;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Date Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }
    
}
