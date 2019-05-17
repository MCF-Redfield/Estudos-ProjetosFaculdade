package br.com.mcf.service;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Mcf
 */
public class ProdutoServiceImpl {

    
    List<String> listaLivro = new ArrayList<>();
    List<String> listaFilme = new ArrayList<>();
    List<String> listaMusica = new ArrayList<>();
     
    public ProdutoServiceImpl()
    {
        listaLivro.add("Java: como programar");
        listaLivro.add("Programando em C");
        listaLivro.add("Álgebra Linear");
        
        listaMusica.add("Sofrência Vavá");
        listaMusica.add("Homem não Chora");
        listaMusica.add("Dao Dao DAo");
        
        listaFilme.add("Titanic");
        listaFilme.add("The Avengers 2");
        listaFilme.add("Isso Aí");
        
    }
    public List<String> getProdutoCategorias()
    {   
        List<String> categorias = new ArrayList<>();
        categorias.add("Livros");
        categorias.add("Musicas");
        categorias.add("Filmes");
        return categorias;
    }    
    
    public List<String> getProdutos(String categoria)
    {
        switch(categoria.toLowerCase())
        {
            case "livros":
                return listaLivro;
            case "filmes":
                return listaFilme;
            case "musicas":
                return listaMusica;
        }
        return null;
    }
    
    public boolean addProduto(String categoria, String produto)
    {
        switch(categoria.toLowerCase())
        {
            case "livros":
                listaLivro.add(produto);
                break;
            case "filmes":
                listaFilme.add(produto);
                break;
            case "musicas":
                listaMusica.add(produto);
                break;
            default: return false;
        }
        return true;        
    }
}
