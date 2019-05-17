/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Random;

/**
 *
 * @author Matheus Correia
 */
public class Servicos {

    private static int qtde;
    private static int sadqtd;
    private static int sadresult;

    public int getSadresult() {
        return sadresult;
    }

    public void setSadresult(int sadresult) {
        Servicos.sadresult += sadresult;
    }
    
    
    public int getSadqtd() {
        return sadqtd;
    }

    public void setSadqtd(int sadqtd) {
        Servicos.sadqtd += sadqtd;
    }

    public void setQtde(int qtde) {
        Servicos.qtde += qtde;
    }

    public int getQtde() {
        return qtde;
    }

    public int quantidadeDeCarta(int tam)//Para saber a quantidade de cartas
    {
        if (tam != 2) {
            return 1 + quantidadeDeCarta(tam / 2);

        } else {
            return 1;
        }
    }

    public int[][] cartas(int tam) {

        int[][] matriz = new int[quantidadeDeCarta(tam)][tam / 2];
        int y, x = 0;

        for (y = 0; y < quantidadeDeCarta(tam); y++)//Qtde de cartas
        {
            for (int i = 1; i <= tam; i++)//Qtde de números
            {
                if (i % (Math.pow(2, y) * 2) == 0)//
                {
                    for (int j = (int) (i - Math.pow(2, y)); j <= i - 1; j++) {
                        matriz[y][x] = j;
                        x++;
                    }
                }
            }
            x = 0;
        }
        return matriz;
    }

    public int[] sortearCarta(int qtde) {
        Random sorte = new Random();
        int[] indicesCartas = new int[qtde];
        for (int j = 0; j < qtde; j++) {
            indicesCartas[j] = -1;
        }

        int i = 0, indice;
        while (i < qtde) {
            indice = sorte.nextInt(qtde);
            if (verificaIndices(indicesCartas, indice) == true) {
                indicesCartas[i] = indice;
                i++;
            }
        }

        for (int j = 0; j < qtde; j++) {
            System.out.println(j + "»" + (indicesCartas[j]) + " ");
        }

        return indicesCartas;
    }

    public boolean verificaIndices(int[] indices, int ind) {
        for (int i = 0; i < indices.length; i++) {
            if (ind == indices[i]) {
                return false;
            }
        }
        return true;

    }
}
