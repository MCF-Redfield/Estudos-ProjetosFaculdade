package persistence.dao;

/**
 *
 * @author Matheus Correia
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Distribuidora;
import persistence.fabrica.ConnectionFactory;

public class DistribuidoraDAO{

    Connection connection;

    public DistribuidoraDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    
    public void adicionar(Distribuidora dist) {
        String sql = "INSERT INTO distribuidora" + "(nome,sede)" + "VALUES (?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, dist.getNome());
                stmt.setString(2, dist.getSede());

                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DistribuidoraDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public Distribuidora buscarPorId(int id) {
        String sql = "SELECT * FROM distribuidora WHERE cod = " + id;
        Distribuidora dist = new Distribuidora();
        
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                //stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    dist.setCod(rs.getInt("cod"));
                    dist.setNome(rs.getString("nome"));
                    dist.setSede(rs.getString("sede"));
                }
                return dist;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DistribuidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/*
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
*/
    public List<Distribuidora> getLista() {
        String sql = "SELECT * FROM distribuidora";

        try {
            List<Distribuidora> listaDistribuidora = new ArrayList<Distribuidora>();
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Distribuidora dist = new Distribuidora();
                    dist.setNome(rs.getString("nome"));
                    dist.setSede(rs.getString("sede"));
                    listaDistribuidora.add(dist);
                }
            }
            return listaDistribuidora;

        } catch (SQLException e) {
            Logger.getLogger(DistribuidoraDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }
/*
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
    }*/
}
