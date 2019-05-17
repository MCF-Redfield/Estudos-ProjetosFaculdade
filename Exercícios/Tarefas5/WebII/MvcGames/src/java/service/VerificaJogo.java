/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import model.Jogo;
import persistence.dao.JogoDAO;

/**
 *
 * @author Usuario
 */
public class VerificaJogo {
    public static String[] resultado1;
    public boolean adicionarJogo(Jogo jogo) throws ClassNotFoundException
    {                
        if((jogo.getDesenv()==null) || (jogo.getNome().isEmpty()) || (jogo.getPlataforma().isEmpty()) || (jogo.getGenero().isEmpty()) || (jogo.getStatus().isEmpty()))//se tiver campo vazio
        {     
           String[] resultado = {"Preencha os campos corretamente","Não foi possível realizar o cadastro!!!"}; 
           resultado1=resultado;
           return false;
        }           
        else
            if(jogo.getDesenv().getNome()==null && (!(jogo.getNome().isEmpty()) && !(jogo.getPlataforma().isEmpty()) && !(jogo.getGenero().isEmpty()) && !(jogo.getStatus().isEmpty())))//desenvolvedora não encontrada
            {   
                String[] resultado = {"Não foi possível localizar Desenvolvedora com código informado!!","Desenvolvedora inválida ou não informada!!"};
                resultado1=resultado;
                return false;
            }
        else
            {
                String[] resultado = {"Jogo cadastrado!",jogo.getNome() + " cadastrado com sucesso!!"};
                resultado1=resultado;
                return true;
            }
        
    }
}
