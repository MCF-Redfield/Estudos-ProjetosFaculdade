package br.com.tchunaifashion.model;

import java.sql.Date;

/**
 *
 * @author Matheus Correia
 */
public class Pedido
{
    private int idPed;
    private java.sql.Date data;
    private Cliente cliente;
    private Double total;

    public Pedido() {
    }

    public Pedido(int idPed, Date data, Cliente cliente, Double total) {
        this.idPed = idPed;
        this.data = data;
        this.cliente = cliente;
        this.total = total;
    }

    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}
