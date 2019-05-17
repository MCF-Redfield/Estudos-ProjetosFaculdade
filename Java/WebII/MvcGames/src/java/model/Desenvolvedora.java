/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Matheus COrreia
 */
public class Desenvolvedora {
    
    private int cod;
    private String nome; 
    private String sede; 
    Distribuidora dist;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Distribuidora getDist() {
        return dist;
    }

    public void setDist(Distribuidora dist) {
        this.dist = dist;
    }
        
}
