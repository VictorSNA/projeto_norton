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
public class Conta{
    private double valor_total;
    private double total_consumo;
    private double diaria;

    public Conta(double valor_total, double total_consumo, double diaria) {
        this.valor_total = valor_total;
        this.total_consumo = total_consumo;
        this.diaria = diaria;
    }

    public void fecharConta(){
        //todo
    }

    public void gerarNota(){
        //todo
    }

    public double getValorTotal() {
        return valor_total;
    }

    public void setValorTotal(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getTotalConsumo() {
        return total_consumo;
    }

    public void setTotalConsumo(double totalConsumo) {
        this.total_consumo = totalConsumo;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }
}
