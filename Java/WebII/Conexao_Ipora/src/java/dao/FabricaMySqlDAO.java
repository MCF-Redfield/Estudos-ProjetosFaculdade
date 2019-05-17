package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos da Costa Oliveira
 */
public class FabricaMySqlDAO extends fabricaDAO {

    public EventoDAO getEventoDAO() {
        try {
            return new EventoDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FabricaMySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public AnuncianteDAO getAnuncianteDAO() {
        try {
            return new AnuncianteDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FabricaMySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Connection connection() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ipora",
                    "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
