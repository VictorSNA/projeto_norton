/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;

/**
 *
 * @author Thiago
 */
public class Reserva {
    private Quarto quarto;
    private String datain;
    private String dataout;
    private float valor;
    private boolean pago;

    public Reserva(Quarto quarto, String datain, String dataout, float valor, boolean pago) {
        this.quarto = quarto;
        this.datain = datain;
        this.dataout = dataout;
        this.valor = valor;
        this.pago = pago;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDatain() {
        return datain;
    }

    public void setDatain(String datain) {
        this.datain = datain;
    }

    public String getDataout() {
        return dataout;
    }

    public void setDataout(String dataout) {
        this.dataout = dataout;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
