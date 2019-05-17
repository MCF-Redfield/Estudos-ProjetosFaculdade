/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author aluno
 */
public class ControleDePontoNovo {

    public void registra(Funcionario f, boolean entrada) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "dd/MM/yyyy H:m:s");
        String format = simpleDateFormat.format(calendar.getTime());
        if (entrada == true) {
            System.out.println(" Entrada : " + f.getNome() + " às " + format);
        } else {
            System.out.println(" Saída : " + f.getNome() + " às " + format);
        }
    }
}
