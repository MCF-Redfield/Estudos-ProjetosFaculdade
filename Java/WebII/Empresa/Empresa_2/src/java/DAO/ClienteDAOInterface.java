
package DAO;

import DTO.Cliente;

interface ClienteDAOInterface {
    
    public void add(Cliente cliente);
    
    public void remover(String cpf);
    
}
