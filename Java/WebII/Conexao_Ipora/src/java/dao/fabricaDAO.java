
package dao;

/**
 *
 * @author Carlos da Costa Oliveira
 */
public abstract class fabricaDAO {
    public abstract AnuncianteDAO getAnuncianteDAO();
    
    public abstract EventoDAO getEventoDAO();
    
    public static fabricaDAO getFabricaDAO(){
    return new FabricaMySqlDAO();
    }
}
