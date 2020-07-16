/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelaria;

import DTO.Atendente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author victo
 */
public class AtendenteTableModel extends AbstractTableModel {
    private List<Atendente> dados = new ArrayList<>();
    private String[] colunas = {"codigo","nome","email", "senha"};

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
            case 1: return this.dados.get(linha).getNome();
            case 2: return this.dados.get(linha).getEmail();
            case 3: return this.dados.get(linha).getSenha();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int coluna) {
        return getColunas()[coluna];
    }
    public List<Atendente> getDados() {
        return dados;
    }
    
    public void setDados(List<Atendente> dados) {
        this.dados = dados;
    }
    public String[] getColunas() {
        return colunas;
    }
    
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    public Atendente retornaObjeto(int linha){
        return dados.get(linha);
    }
    
}
