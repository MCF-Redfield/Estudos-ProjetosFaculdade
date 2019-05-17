
package DAO;

import DTO.Fornecedor;


interface FornecedorDAOInterface {
     
    public void add(Fornecedor fornecedor);
    
    public void remover(String cnpj);
      
}
