package br.edu.infnet.TechStore.model.domain;

public class Usuario {

    private Integer id;
    private String username;
    private String password;
    private String cpf;
    private String cargo;
    private String setor;
    private String email;


    public Usuario(){

    }

    public Usuario(String email, String senha) {
        this();
        this.setEmail(email);
        this.setPassword(senha);
    }

    public Usuario(String nome, String email, String senha) {
        this(email, senha);
        this.setUsername(nome);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCargo() {
        return cargo;
    }

    public String getUsername() {
        return username;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

}
