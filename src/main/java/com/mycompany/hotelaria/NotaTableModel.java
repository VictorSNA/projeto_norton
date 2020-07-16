/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelaria;

import DTO.Nota;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author victo
 */
public class NotaTableModel extends AbstractTableModel{
    private List<Nota> dados = new ArrayList<>();
    private String[] colunas = {"numero","dataEmissao","valor"};

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
            case 0: return this.dados.get(linha).getNumero();
            case 1: return this.dados.get(linha).getDataEmissao();
            case 2: return this.dados.get(linha).getValor();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int coluna) {
        return getColunas()[coluna];
    }
    public List<Nota> getDados() {
        return dados;
    }
    
    public void setDados(List<Nota> dados) {
        this.dados = dados;
    }
    public String[] getColunas() {
        return colunas;
    }
    
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    public Nota retornaObjeto(int linha){
        return dados.get(linha);
    }
}
