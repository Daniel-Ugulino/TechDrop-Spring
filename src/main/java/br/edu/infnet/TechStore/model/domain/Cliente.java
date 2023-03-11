package br.edu.infnet.TechStore.model.domain;

import  br.edu.infnet.TechStore.model.execptions.ClienteException;

public class Cliente {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private String nascimento;
    private String endereco;
    private String cep;
    private String telefone;

    public Cliente(){}

    public Cliente(String nome,String cpf,String nascimento,String endereco,String cep) throws ClienteException {
        if(nome == "") {
            throw new ClienteException("O nome do cliente deve ser preenchido!");
        }

        if(nascimento == "") {
            throw new ClienteException("A idade do cliente deve ser preenchido!");
        }

        if(cpf == "") {
            throw new ClienteException("O cpf do cliente deve ser preenchido!");
        }

        if(endereco == "") {
            throw new ClienteException("O endereco do cliente deve ser preenchido!");
        }

        if(cep == "") {
            throw new ClienteException("O cep do cliente deve ser preenchido!");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cep = cep;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente\n");
        sb.append("Nome: ");
        sb.append(nome);
        sb.append(" | Cpf:");
        sb.append(cpf);
        sb.append(" | Idade:");
        sb.append(nascimento);
        sb.append(" | Endereço:");
        sb.append(endereco);
        sb.append(" | Cep:");
        sb.append(cep);
        return sb.toString();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNascimento(String idade) {
        this.nascimento = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public Integer getId() {
        return id;
    }

    public String getNome(){return nome;}
    public String getNascimento(){return nascimento;}
    public String getCep(){return cep;}
    public String getCpf(){return cpf;}
    public String getEndereco(){return endereco;}

}
