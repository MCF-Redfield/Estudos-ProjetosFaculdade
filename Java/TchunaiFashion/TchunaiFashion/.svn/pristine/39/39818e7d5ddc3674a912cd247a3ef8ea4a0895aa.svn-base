package br.com.tchunaifashion.persistence.dao;

import br.com.tchunaifashion.model.PedProd;
import br.com.tchunaifashion.model.Produto;
import br.com.tchunaifashion.persistence.fabrica.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Correia
 */
public class PedProdDAO implements InterfacePedProdDAO
{

    Connection connection;//Variável conexão com BD

    /**
     * Construtor inicializa conexão BD
     *
     */
    public PedProdDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void addPedProd(PedProd pedProd)
    {
        String sql = "INSERT INTO pedProd" + "(idPed2,idProd2,tamanho)" + "VALUES (?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, pedProd.getPedido().getIdPed());
                stmt.setInt(2, pedProd.getProduto().getIdProd());
                stmt.setString(3, pedProd.getProduto().getTamanho());
                stmt.execute();

            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Produto> buscaProdsdoPed(int ped)
    {
        String sql = "select * from pedProd where idPed2 = " + ped + ";";
        ProdutoDAO prodDAO = new ProdutoDAO();
        List<Produto> listaProdPorPed = new ArrayList<>();
        try {
            try (
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next())
                {
                    Produto prod = prodDAO.buscaProdporID(rs.getInt("idProd2"));
                    prod.setTamanho(rs.getString("tamanho"));
                    listaProdPorPed.add(prod);
                }
            }
            return listaProdPorPed;

        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }
}
