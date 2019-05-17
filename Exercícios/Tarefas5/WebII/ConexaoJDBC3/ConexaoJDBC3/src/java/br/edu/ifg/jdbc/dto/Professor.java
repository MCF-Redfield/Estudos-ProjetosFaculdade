
package br.edu.ifg.jdbc.dto;

public class Professor {
    
      
    private int id;
    private int numSiape;
    private int codContrato;
    private String nome;

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
    
     public int getnumSiape() {
        return numSiape;
    }

    public void setnumSiape(int numSiape) {
        this.numSiape = numSiape;
    }
    
    public int getcodContrato() {
        return codContrato;
    }

    public void setcodContrato(int codContrato) {
        this.codContrato = codContrato;
    }
    
}
