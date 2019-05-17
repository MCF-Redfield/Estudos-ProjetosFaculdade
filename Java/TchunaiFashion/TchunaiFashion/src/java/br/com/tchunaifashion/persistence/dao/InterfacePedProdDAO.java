package br.com.tchunaifashion.persistence.dao;

import br.com.tchunaifashion.model.PedProd;
import br.com.tchunaifashion.model.Produto;
import java.util.List;

/**
 *
 * @author Matheus Correia
 */
public interface InterfacePedProdDAO
{
    public void addPedProd(PedProd pedProd);
    public List<Produto> buscaProdsdoPed(int ped);
}
