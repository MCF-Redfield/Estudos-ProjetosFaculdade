package questao4lista4pooi;

/**
 *
 * @author Matheus Correia
 */
public class Empresa implements java.io.Serializable {
    private String nome;
    private String cnpj;
    private final Departamento departamento[]=new Departamento[10];

     public static int qtdeDep = 0;
     
    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Departamento[] getDepartamneto() {
        return departamento;
    }

    public void setDepartamneto(Departamento dep) {
        this.departamento[qtdeDep] = dep;
        qtdeDep++;
    } 
    

    
     public String mostrarDepartamento(){
        String concatena="";
        for (int i = 0; i < qtdeDep; i++) {
            concatena = concatena + departamento[i].toString()+"\n";
            
        }
        return concatena;
    }

    @Override
    public String toString() {
        return "Empresa\nNome: " + nome + "\nCNPJ: " + cnpj + "\nDepartamento: " + mostrarDepartamento();
    }
    
     
    
}
