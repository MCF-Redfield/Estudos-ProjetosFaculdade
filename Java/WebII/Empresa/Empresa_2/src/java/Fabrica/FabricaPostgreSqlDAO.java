
package Fabrica;

import DAO.ClienteDAO;
import DAO.FornecedorDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaPostgreSqlDAO extends FabricaDAO {

   @Override
   public ClienteDAO getClienteDAO(){
       try {
           return new ClienteDAO();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(FabricaPostgreSqlDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
   
   @Override
   public FornecedorDAO getFornecedorDAO(){
       try {
           return new FornecedorDAO();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(FabricaPostgreSqlDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
}

   public static Connection criarConexao() throws ClassNotFoundException{
		  try {
            Class.forName("org.postgresql.Driver");   
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa",
                    "postgres", "123");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

}

}
