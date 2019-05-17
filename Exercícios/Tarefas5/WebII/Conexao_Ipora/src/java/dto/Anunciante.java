
package dto;

/**
 *
 * @author Carlos da Costa Oliveira
 */
public class Anunciante {
    private String cpf;
    private String nome;

    public Anunciante() {
    }
    
    
    public Anunciante(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Anunciante" + "\nCPF = " + cpf + "Nome = " + nome;
    }
    
}
