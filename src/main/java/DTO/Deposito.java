/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author victo
 */
public class Deposito {
    private Long codigo;
    private Double valor;
    private String dataDeposito;
    
    public Deposito(Double pValor){
        this.setValor(pValor);
    }
    
    
    public void consultar(){
        //DAO
    }
    
    
    public void inserir(){
        //DAO
    }
    
    public void efetivar(){
        //DAO
    }
    
    /**
     * @return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the dataDeposito
     */
    public String getDataDeposito() {
        return dataDeposito;
    }

    /**
     * @param dataDeposito the dataDeposito to set
     */
    public void setDataDeposito(String dataDeposito) {
        this.dataDeposito = dataDeposito;
    }
}
