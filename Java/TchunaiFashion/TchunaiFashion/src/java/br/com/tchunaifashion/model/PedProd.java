package br.com.tchunaifashion.model;
/**
 *
 * @author Matheus Correia
 */
public class PedProd
{
    private Pedido pedido;
    private Produto produto;
    private String tamanho;
    
    public PedProd() {
    }

    public PedProd(Pedido pedido, Produto produto, String tamanho) {
        this.pedido = pedido;
        this.produto = produto;
        this.tamanho = tamanho;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
