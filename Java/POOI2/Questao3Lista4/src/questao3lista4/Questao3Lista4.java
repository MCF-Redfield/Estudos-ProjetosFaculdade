/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3lista4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author livre
 */
public class Questao3Lista4 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String nomeArq = JOptionPane.showInputDialog(null, "Informe o arquivo: ");
        File file = new File(nomeArq);
        if (file.isFile())
        {
            JOptionPane.showMessageDialog(null, "Arquivo existe.");
            gravaArq(nomeArq);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Arquivo não existia mas foi  criado.");
            gravaArq(nomeArq);
        }

        
    }

    public static void gravaArq(String nomeArq) throws IOException
        {
            String textoArq = JOptionPane.showInputDialog(null, "Informe texto a ser escrito no arquivo: ");

            try (FileWriter arq = new FileWriter(nomeArq)) {
                PrintWriter gravarArq = new PrintWriter(arq);

                gravarArq.printf(textoArq);
            }

            System.out.printf("\nDados gravados com sucesso em '"+nomeArq+"'");

        }
}
