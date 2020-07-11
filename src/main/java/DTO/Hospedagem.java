/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class Hospedagem extends Reserva{
    private List<Servico> gastos = new ArrayList<Servico>();
    private int diarias;
    private double valorTotal;
    private Nota notafiscal;
            
    public Hospedagem(Quarto quarto, Cliente cliente, String datain, String dataout, float valor, boolean pago) {
        super(quarto, cliente, datain, dataout, valor, pago);
    }
    
    public void checkin(Reserva reserva){
        Hospedagem obj = (Hospedagem)reserva;
    }
    
    public void adicionarGasto(Servico obj){
        gastos.add(obj);
    }
    
    public void calculaTotal(){
        double totalDiarias = this.diarias * this.getQuarto().getValorDiaria();
        double totalGastos = 0;
        for(Servico obj : gastos){
            totalGastos += obj.getValor();
        }
        this.setValorTotal(totalDiarias + totalGastos);
    }
    
    public void fecharConta(){
        //DAO
        calculaTotal();
        Nota obj = new Nota(1L, "DATA ATUAL", this.getValorTotal());
    
    this.setNotafiscal(obj);
    }
    /**
     * @return the diarias
     */
    public int getDiarias() {
        return diarias;
    }

    /**
     * @param diarias the diarias to set
     */
    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the notafiscal
     */
    public Nota getNotafiscal() {
        return notafiscal;
    }

    /**
     * @param notafiscal the notafiscal to set
     */
    public void setNotafiscal(Nota notafiscal) {
        this.notafiscal = notafiscal;
    }
    
}
