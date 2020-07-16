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
public class Quarto {
    private int numero;
    private String tipo;
    private String descricao;
    private boolean ocupado;
    private double valorDiaria;

    public Quarto(String tipo, String descricao, boolean ocupado, double valorDiaria) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.ocupado = ocupado;
        this.valorDiaria = valorDiaria;
    }

    public void verificarDisponibilidade(){
        //todo
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponivel() {
        return isOcupado();
    }

    public void setDisponivel(boolean disponivel) {
        this.setOcupado(disponivel);
    }

    /**
     * @return the ocupado
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * @param ocupado the ocupado to set
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    /**
     * @return the valorDiaria
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * @param valorDiaria the valorDiaria to set
     */
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
