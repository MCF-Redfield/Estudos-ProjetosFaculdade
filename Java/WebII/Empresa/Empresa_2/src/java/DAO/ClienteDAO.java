package DAO;

import DTO.Cliente;
import Fabrica.FabricaPostgreSqlDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO extends FabricaPostgreSqlDAO implements ClienteDAOInterface {

    Connection connection;

    public ClienteDAO() throws ClassNotFoundException {
        this.connection = FabricaPostgreSqlDAO.criarConexao();
    }

    @Override
    public void add(Cliente cliente) {
        String sql = "INSERT INTO cliente" + "(nome,telefone,endereco,cpf)" + "VALUES (?,?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getTelefone());
                stmt.setString(3, cliente.getEndereco());
                stmt.setString(4, cliente.getCpf());
                stmt.execute();
                
                System.out.println("Cliente Salvo!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf like ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.execute();
            System.out.println("Cliente Deletado!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
