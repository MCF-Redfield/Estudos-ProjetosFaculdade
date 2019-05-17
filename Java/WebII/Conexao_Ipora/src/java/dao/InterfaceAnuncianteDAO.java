
package dao;

import dto.Anunciante;
import java.util.List;

/**
 *
 * @author Carlos da Costa Oliveira
 */
public interface InterfaceAnuncianteDAO {
    public void adicionar(Anunciante anunciante);
    public void remover(Anunciante anunciante);
    public void alterar(Anunciante anunciante);
    public List<Anunciante> getLista();
    public Anunciante buscarPorCPF(String cpf);    
}
