
package fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos da Costa Oliveira
 */
public class ConnectionFactory {
    
    
    public Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName("org.postgresql.Driver"); 
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ipora",
                    "postgres","1234");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
