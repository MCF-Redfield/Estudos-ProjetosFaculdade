package br.com.tchunaifashion.persistence.dao;

import br.com.tchunaifashion.model.Pedido;
import java.util.List;

/**
 *
 * @author Matheus Correia
 */
public interface InterfacePedidoDAO
{
    public void addPedido(Pedido pedido);
    public Pedido pedMaisRecente();
    public List<Pedido> listaPedPorCli(String cpf);
}
