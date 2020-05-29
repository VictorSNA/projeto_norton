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
    private Cliente cliente;
    private String datain;
    private String dataout;
    private float valor;
    private boolean pago;

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
