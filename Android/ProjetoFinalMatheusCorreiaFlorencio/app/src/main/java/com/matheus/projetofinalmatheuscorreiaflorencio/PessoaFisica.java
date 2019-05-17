package com.matheus.projetofinalmatheuscorreiaflorencio;

/**
 * Created by Matheus on 28/06/2017.
 */

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Matheus Correia Florêncio
//******************************************************

public class PessoaFisica
{
    private String nome;
    private String cpf;
    private int idade;
    private String fone;
    private String email;

    public PessoaFisica(String cpf, String email, String fone, int idade, String nome)
    {
        this.cpf = cpf;
        this.email = email;
        this.fone = fone;
        this.idade = idade;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
