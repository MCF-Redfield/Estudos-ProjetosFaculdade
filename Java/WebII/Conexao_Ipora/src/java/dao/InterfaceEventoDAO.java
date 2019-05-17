
package dao;

import dto.Evento;
import java.util.List;

/**
 *
 * @author Carlos da Costa Oliveira
 */
public interface InterfaceEventoDAO {
    public void adicionar(Evento evento);
    public void remover(Evento evento);
    public void alterar(Evento evento);
    public List<Evento> getEvento();
}
