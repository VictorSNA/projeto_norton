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
public class Quarto {
    private int numero;
    private String tipo;
    private String descricao;
    private boolean ocupado;

    public Quarto(int numero, String tipo, String descricao, boolean ocupado) {
        this.numero = numero;
        this.tipo = tipo;
        this.descricao = descricao;
        this.ocupado = ocupado;
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
        return ocupado;
    }

    public void setDisponivel(boolean disponivel) {
        this.ocupado = disponivel;
    }
}
