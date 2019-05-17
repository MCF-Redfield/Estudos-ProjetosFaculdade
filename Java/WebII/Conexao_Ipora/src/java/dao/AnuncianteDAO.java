package dao;

import dto.Anunciante;
import fabrica.ConnectionFactory;
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
 * @author Carlos da Costa Oliveira
 */
public class AnuncianteDAO implements InterfaceAnuncianteDAO {

    Connection connection;

    public AnuncianteDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void adicionar(Anunciante anunciante) {
        String sql = "INSERT INTO anunciante" + "(cpf,nome)" + "VALUES (?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, anunciante.getCpf());
                stmt.setString(2, anunciante.getNome());

                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnuncianteDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void remover(Anunciante anunciante) {
        String sql = "DELETE FROM anunciante WHERE cpf LIKE ? ";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, anunciante.getCpf());
                stmt.execute();
            }

        } catch (SQLException e) {
            Logger.getLogger(AnuncianteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Anunciante> getLista() {
        String sql = "SELECT * FROM anunciante";

        try {
            List<Anunciante> listaAnunciante = new ArrayList<Anunciante>();
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Anunciante anunciante = new Anunciante();
                    anunciante.setCpf(rs.getString("cpf"));
                    anunciante.setNome(rs.getString("nome"));
                    listaAnunciante.add(anunciante);
                }
            }
            return listaAnunciante;

        } catch (SQLException e) {
            Logger.getLogger(AnuncianteDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }

    @Override
    public void alterar(Anunciante anunciante) {
        String sql = "UPDATE anunciante SET cpf=?, nome=? WHERE cpf=?";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, anunciante.getCpf());
                stmt.setString(2, anunciante.getNome());
                stmt.setString(3, anunciante.getCpf());
                
                stmt.execute();
            }

        } catch (SQLException e) {
            Logger.getLogger(AnuncianteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Anunciante buscarPorCPF(String cpf) {
        String sql = "SELECT * FROM anunciante WHERE cpf like '" + cpf + "'";
        Anunciante anunc = new Anunciante();

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                //stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    anunc.setCpf(rs.getString("cpf"));
                    anunc.setNome(rs.getString("nome"));
                }
                return anunc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnuncianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
