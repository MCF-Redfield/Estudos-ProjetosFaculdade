package br.com.tchunaifashion.persistence.fabrica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Matheus Correia
 */

public class ConnectionFactory
{
    public Connection getConnection()
    {
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/tane",
                    "root","");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}