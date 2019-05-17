package br.com.tchunaifashion.model;
/**
 *
 * @author Matheus Correia
 */
public class Produto
{
    private int idProd;
    private String nomeProd;
    private String descricao;
    private String cor;
    private String genero;
    private double preco;
    private String imagem;
    private String tipo;
    private String tamanho;

    public Produto() {
    }

    public Produto(int idProd, String nomeProd, String descricao, String cor, String genero, double preco, String imagem, String tipo, String tamanho) {
        this.idProd = idProd;
        this.nomeProd = nomeProd;
        this.descricao = descricao;
        this.cor = cor;
        this.genero = genero;
        this.preco = preco;
        this.imagem = imagem;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }   
}
