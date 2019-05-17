/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tchunaifashion.services;

/**
 *
 * @author maxwel
 */
public class Autenticacao {

    private String email = "";
    private String senha = "";
    private String message = "";

    public Autenticacao() {
    }

    public Autenticacao(String email, String senha) {
        this.email = email;
        this.senha = senha;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean validate() {

        if (email == null && senha == null) {
            message = "**Email ou senha inválido!!";
            return false;
        }else{
            return true;
        }

        
    }
}
