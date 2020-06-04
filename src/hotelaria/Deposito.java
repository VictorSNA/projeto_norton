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
public class Relatorio {
    private String numero;
    private String data;
    public double valor;

    public Relatorio(String numero, String data, double valor) {
        this.numero = numero;
        this.data = data;
        this.valor = valor;
    }

    public void controlar(){
        //todo
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
