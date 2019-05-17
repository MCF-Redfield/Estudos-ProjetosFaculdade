package br.com.tchunaifashion.services;

import br.com.tchunaifashion.model.Produto;
import java.util.List;
/**
 *
 * @author Matheus Correia
 */
public class UpdateTotal
{
    public Double preco(List<Produto> listaCarrinho)
    {
        int i=0;
        double total=0;
        while(i<listaCarrinho.size())
        {
            total+=listaCarrinho.get(i).getPreco();
            i++;
        }
        return total;
    }
}
