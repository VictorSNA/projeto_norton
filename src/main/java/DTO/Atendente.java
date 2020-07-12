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
public class Atendente {
    private Long codigo;
    private String nome;
    private String email;
    private String senha;


    public Atendente(Long cod, String nome, String email, String senha) {
        this.codigo = cod;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    private boolean fazerlogin(){
        //DAO
        return false;
    }
    
    private boolean cadastrar(){
        //DAO
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}
