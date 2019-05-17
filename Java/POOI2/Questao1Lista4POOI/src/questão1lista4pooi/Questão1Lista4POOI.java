package questão1lista4pooi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Questão1Lista4POOI {

  public static void main(String[] args) throws IOException
  {
    String textoArq;
    textoArq = JOptionPane.showInputDialog("Digite o texto do arquivo:","Texto");
    FileWriter arq = new FileWriter("teste.txt");
    PrintWriter gravarArq = new PrintWriter(arq);

    gravarArq.printf(textoArq);
    
    arq.close();

    System.out.printf("\nDados gravados com sucesso em 'teste.txt'");
  }

}