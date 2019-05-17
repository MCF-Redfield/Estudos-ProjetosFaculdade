package questao4lista4pooi;

/**
 *
 * @author Matheus Correia
 */
public class Funcionario implements java.io.Serializable{
    private String nome;
    private String salario;
    private String dataAdmissao;

    public Funcionario(String nome, String salario, String dataAdmissao) {
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public String toString() {
        return "\nFuncionario\nNome: " + nome + "\nSalario: R$" + salario + "\nData Admissao: " + dataAdmissao;
    }  
}
