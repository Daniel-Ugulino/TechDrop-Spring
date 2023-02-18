package br.edu.infnet.TechStore.model.domain;

import  br.edu.infnet.TechStore.model.execptions.ClienteException;

public class Cliente {

    private String nome;
    private String cpf;
    private Integer idade;
    private String endereco;
    private String cep;

    public Cliente(String nome,String cpf,Integer idade,String endereco,String cep) throws ClienteException {
        if(nome == "") {
            throw new ClienteException("O nome do cliente deve ser preenchido!");
        }

        if(idade == 0) {
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
        this.idade = idade;
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
        sb.append(idade);
        sb.append(" | Endereço:");
        sb.append(endereco);
        sb.append(" | Cep:");
        sb.append(cep);
        return sb.toString();
    }

    public String getNome(){return nome;}
    public Integer getIdade(){return idade;}
    public String getCep(){return cep;}
    public String getCpf(){return cpf;}
    public String getEndereco(){return endereco;}

}
