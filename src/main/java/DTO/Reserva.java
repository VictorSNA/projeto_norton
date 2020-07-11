/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Thiago
 */
public class Reserva {
    private Quarto quarto;
    private Cliente cliente;
    private Deposito deposito;
    private String datain;
    private String dataout;
    private double valor;
    private boolean pago;
 

    public Reserva(Quarto quarto, Cliente cliente, String datain, String dataout, float valor, boolean pago) {
        this.quarto = quarto;
        this.cliente = cliente;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    /**
     * @return the deposito
     */
    public Deposito getDeposito() {
        return deposito;
    }

    /**
     * @param deposito the deposito to set
     */
    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }
}
