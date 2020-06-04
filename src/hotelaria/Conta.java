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
public class Conta {
    private String valor_total;
    private double total_consumo;
    private double diaria;

    public Conta(String tipo_consumo, double total_consumo, double diaria) {
        this.valor_total = tipo_consumo;
        this.total_consumo = total_consumo;
        this.diaria = diaria;
    }

    public void fecharConta(){
        //todo
    }

    public void gerarNota(){
        //todo
    }

    public String getValorTotal() {
        return valor_total;
    }

    public void setValorTotal(String valor_total) {
        this.valor_total = valor_total;
    }

    public String getTotalConsumo() {
        return total_consumo;
    }

    public void setTotalConsumo(double TotalConsumo) {
        this.total_consumo = total_consumo;
    }

    public String getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }
}
