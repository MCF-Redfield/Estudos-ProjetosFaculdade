/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import model.Distribuidora;

/**
 *
 * @author Matheus Correia
 */
public class VerificaDistribuidora {
    
    public boolean adicionarDist(Distribuidora dist)
    {
        if(dist.getNome().isEmpty() || dist.getSede().isEmpty())
            return false;
        else
            return true;        
    }
}
