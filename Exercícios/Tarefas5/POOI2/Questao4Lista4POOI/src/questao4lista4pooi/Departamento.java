package questao4lista4pooi;

/**
 *
 * @author Matheus Correia
 */
public class Departamento implements java.io.Serializable{
    private String nome;
    private Funcionario funcionario[]=new Funcionario[100];

    public static int quantidaFunc = 0;
            
    public Departamento(String nome) {
        this.nome = nome;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public void setFuncionario(Funcionario func) {
        func.setSalario(String.valueOf(aumentodeSalario(Float.parseFloat(func.getSalario()))));
        funcionario[quantidaFunc]=func;
        quantidaFunc++;
        
        
        
    }
    
    public float aumentodeSalario(float money){
       
        money = (float) (money+(money*0.1));
        return money;
    }
    
    public String mostrarFuncionario(){
        String concatena="";
        for (int i = 0; i < quantidaFunc; i++) {
            concatena =concatena+funcionario[i].toString()+"\n";
            
        }
        return concatena;
    }

    @Override
    public String toString() {
        return "\nDepartamento\nNome: " + nome + "\nFuncionario: " + mostrarFuncionario();
    }
    
    
}
