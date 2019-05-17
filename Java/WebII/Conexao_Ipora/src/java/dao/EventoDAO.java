package dao;

import dto.Evento;
import fabrica.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
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
public class EventoDAO implements InterfaceEventoDAO {

    Connection connection;

    public EventoDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void adicionar(Evento evento) {
        String sql = "INSERT INTO evento" + "(nome,local,data,descricao,campus,anunciante_cpf)"
                + "VALUES (?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, evento.getNome());
                stmt.setString(2, evento.getLocal());
                stmt.setDate(3, evento.getData());
                stmt.setString(4, evento.getDescricao());
                stmt.setString(5, evento.getCampus());
                stmt.setString(6, evento.getAnunciante().getCpf());
                
                stmt.execute();
            }

        } catch (SQLException e) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void remover(Evento evento) {
        String sql = "DELETE FROM evento WHERE id LIKE ?";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, evento.getId());
                stmt.execute();
            }

        } catch (SQLException e) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @Override
    public List<Evento> getEvento() {
        try {
            String sql = "SELECT * FROM evento";

            AnuncianteDAO anuncDAO = new AnuncianteDAO();

            try {
                List<Evento> listaEvento = new ArrayList<>();
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    
                    while (rs.next()) {
                        Evento evento = new Evento();
                        evento.setNome(rs.getString("nome"));
                        evento.setLocal(rs.getString("local"));
                        evento.setData(rs.getDate("data"));
                        evento.setDescricao(rs.getString("descricao"));
                        evento.setCampus(rs.getString("campus"));
                        evento.setAnunciante(anuncDAO.buscarPorCPF(rs.getString("anunciante_id")));
                    }
                    rs.close();
                }
                return listaEvento;

            } catch (SQLException e) {
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void alterar(Evento evento) {
        String sql = "UPDATE evento SET id=?,nome=?,local=?,data=?,descricao=?,campus=?,anunciante_id=? WHERE id=?";

        try {

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, evento.getId());
                stmt.setString(2, evento.getNome());
                stmt.setString(3, evento.getLocal());
                stmt.setDate(4, (Date) evento.getData());
                stmt.setString(5, evento.getDescricao());
                stmt.setString(6, evento.getCampus());
                stmt.setString(7, evento.getAnunciante().getCpf());
                
                stmt.execute();
            }

        } catch (SQLException e) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
