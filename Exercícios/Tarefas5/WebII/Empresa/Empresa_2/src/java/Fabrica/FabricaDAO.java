
package Fabrica;

import DAO.ClienteDAO;
import DAO.FornecedorDAO;

public abstract class FabricaDAO {
    public abstract ClienteDAO getClienteDAO();
    
    
    public abstract FornecedorDAO getFornecedorDAO();
    
    public static FabricaDAO getFabricaDAO(){
        return new FabricaPostgreSqlDAO();
    }
}
