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
public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String bairro;
    private String cidade;
    private String estado;
    private String datanasc;
    private String rg;

    public Cliente(String nome, String endereco, String telefone, String bairro, String cidade, String estado, String datanasc, String rg) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.datanasc = datanasc;
        this.rg = rg;
    }
    
    private void consultar(){
        
    }
    
    private void cadastrar(){
        
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
