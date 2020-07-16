/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelaria;

import DTO.Reserva;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author victo
 */
public class ReservaTableModel extends AbstractTableModel{
    private List<Reserva> dados = new ArrayList<>();
    private String[] colunas = {"quarto","cliente","datain", "dataout","valor","pago"};

    @Override
    public int getRowCount() {
        return getDados().size();
    }

    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0: return this.dados.get(linha).getCodigo();
            case 1: return this.dados.get(linha).getQuarto().getNumero();
            case 2: return this.dados.get(linha).getCliente().getNome();
            case 3: return this.dados.get(linha).getDatain();
            case 4: return this.dados.get(linha).getDataout();
            case 5: return this.dados.get(linha).getValor();
            case 6: return this.dados.get(linha).isPago();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int coluna) {
        return getColunas()[coluna];
    }
    public List<Reserva> getDados() {
        return dados;
    }
    
    public void setDados(List<Reserva> dados) {
        this.dados = dados;
    }
    public String[] getColunas() {
        return colunas;
    }
    
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    public Reserva retornaObjeto(int linha){
        return dados.get(linha);
    }
}
