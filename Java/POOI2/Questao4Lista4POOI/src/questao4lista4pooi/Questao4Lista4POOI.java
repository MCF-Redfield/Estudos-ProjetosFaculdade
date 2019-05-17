package questao4lista4pooi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Matheus Correia
 */
public class Questao4Lista4POOI {

   public static void main(String[] args) {
          Funcionario func = new Funcionario("Jose","2668","12/05/2016");
          Departamento dep = new Departamento("TI");
          Empresa emp = new Empresa("Manius","12345678/0001-05");
          
          dep.setFuncionario(func);
          emp.setDepartamneto(dep);
          System.out.print(emp.toString());
          
        try{
            FileOutputStream arquivo = new FileOutputStream("teste.txt");
              try (ObjectOutputStream obj = new ObjectOutputStream(arquivo) 
              ) {
                  obj.writeObject(emp);
              } 
        }catch(IOException e){
            System.err.println("Erro na criação do arquivo");
        }  
        
         try{
            FileInputStream arquivo=new FileInputStream("teste.txt");
            Empresa emp2;
              try (ObjectInputStream obj = new ObjectInputStream(arquivo) 
              ) {
                  emp2 = (Empresa) obj.readObject(); 
              } 
             System.out.print(emp2.toString());
        }catch(IOException | ClassNotFoundException e){
             System.err.println("Erro na Leitura do arquivo");
        }  
    }
    
}
