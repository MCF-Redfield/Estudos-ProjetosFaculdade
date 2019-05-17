package br.com.mcf.catalogo;

import br.com.mcf.service.ProdutoServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Mcf
 */
@WebService
public class ProdutoCatalogo
{
    ProdutoServiceImpl produtoService = new ProdutoServiceImpl();
    
    @WebMethod
    public List<String> getProdutoCategorias()
    {        
        return produtoService.getProdutoCategorias();
    }
    
    @WebMethod
    public List<String> getProdutos(String categoria)
    {
        return produtoService.getProdutos(categoria);
    }
    
    @WebMethod(operationName = "Xablau")
    public boolean addProduto(String categoria, String produto)
    {
     return produtoService.addProduto(categoria, produto);
    }
}
