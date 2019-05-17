/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import model.Desenvolvedora;

/**
 *
 * @author Usuario
 */
public class VerificaDesenvolvedora {

    public int adicionarDesenv(Desenvolvedora desenv)
    {
        
        if((desenv.getDist()==null) || (desenv.getNome().isEmpty()) || (desenv.getSede().isEmpty()))
        {
            return 1;
        }
        else if((desenv.getDist()==null) && !(desenv.getNome().isEmpty()) && !(desenv.getSede().isEmpty()))
        {
            return 2;
        }
        else 
            return 3;
    }
}
