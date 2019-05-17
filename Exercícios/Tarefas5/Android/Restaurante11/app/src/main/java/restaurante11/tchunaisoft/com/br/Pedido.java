package restaurante11.tchunaisoft.com.br;

import java.io.Serializable;

/**
 * Created by Usuario on 28/04/2015.
 */
public class Pedido implements Serializable{

    private String codPed;
    private String descrPed;
    private double totalPed;
    public static final long  serialVersionUID = 100L;

    public Pedido(String codPed, String descrPed, double totalPed) {
        this.codPed = codPed;
        this.descrPed = descrPed;
        this.totalPed = totalPed;
    }

    public String getCodPed() {
        return codPed;
    }

    public void setCodPed(String codPed) {
        this.codPed = codPed;
    }

    public String getDescrPed() {
        return descrPed;
    }

    public void setDescrPed(String descrPed) {
        this.descrPed = descrPed;
    }

    public double getTotalPed() {
        return totalPed;
    }

    public void setTotalPed(double totalPed) {
        this.totalPed = totalPed;
    }
}
