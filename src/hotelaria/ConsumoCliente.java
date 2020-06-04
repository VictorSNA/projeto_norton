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
public class ConsumoCliente {
    private String tipo_consumo;
    private double valor_consumo;
    private String data_consumo;

    public ConsumoCliente(String tipo_consumo, double valor_consumo, String data_consumo) {
        this.tipo_consumo = tipo_consumo;
        this.valor_consumo = valor_consumo;
        this.data_consumo = data_consumo;
    }

    public void registrarConsumo(){
        //todo
    }

    public String getTipoConsumo() {
        return tipo_consumo;
    }

    public void setTipoConsumo(String tipo_consumo) {
        this.tipo_consumo = tipo_consumo;
    }

    public double getValorConsumo() {
        return valor_consumo;
    }

    public void setValorConsumo(double valor_consumo) {
        this.valor_consumo = valor_consumo;
    }

    public String getDataConsumo() {
        return data_consumo;
    }

    public void setDataConsumo(String data_consumo) {
        this.data_consumo = data_consumo;
    }
}
