
package DAO;

import DTO.Fornecedor;
import Fabrica.FabricaPostgreSqlDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDAO extends FabricaPostgreSqlDAO implements FornecedorDAOInterface {
       
     Connection connection;

    public FornecedorDAO() throws ClassNotFoundException {
        this.connection = FabricaPostgreSqlDAO.criarConexao();
    }
    
   @Override
    public void add(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor" + "(nome,endereco,cnpj)" + "VALUES (?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, fornecedor.getNome());
                stmt.setString(2, fornecedor.getEndereco());
                stmt.setString(3, fornecedor.getCnpj());
                stmt.execute();
                System.out.println("Fornecedor Salvo!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(String cnpj) {
        String sql = "DELETE FROM fornecedor WHERE cnpj like ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cnpj);
            stmt.execute();
            System.out.println("Fornecedor deletado!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

}
