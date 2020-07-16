/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public class ClienteDAO {
private ConexaoSQLite conexao = new ConexaoSQLite();

    public ClienteDAO(){
        try{
            String sql = 
                "CREATE TABLE IF NOT EXISTS cliente("
                    + "codigo integer PRIMARY KEY AUTOINCREMENT,"
                    + "nome varchar(60) NOT NULL,"
                    + "email varchar(60) NOT NULL, "
                    + "endereco varchar(100) NOT NULL)"
                    + "telefone varchar(20) NOT NULL)"
                    + "datanasc varchar(10) NOT NULL)"
                    + "CPF varchar(10) NOT NULL)";
            if(conexao.conectar()){
                Statement stmt = conexao.retornaStatement();
                stmt.execute(sql);
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();
        }
    }
    
    public int inserir(Cliente obj){
        int cont = 0;
        try{
            if(conexao.conectar()){ 
                String sql = "insert into cliente(nome,email,endereco,telefone,datanasc,CPF)"
                        + " values(?,?,?,?,?,?)";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getEmail());
                stmt.setString(3, obj.getEndereco());
                stmt.setString(4, obj.getTelefone());
                stmt.setString(5, obj.getDatanasc());
                stmt.setString(6, obj.getCPF());
                cont = stmt.executeUpdate();
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();
            return cont;
        }
    }
    
    public int alterar(Cliente obj){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update cliente set nome=?,email=?,endereco=?,telefone=?,datanasc=?,CPF=?"
                        + "where codigo=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getEmail());
                stmt.setString(3, obj.getEndereco());
                stmt.setString(4, obj.getTelefone());
                stmt.setString(5, obj.getDatanasc());
                stmt.setString(6, obj.getCPF());
                stmt.setLong(7, obj.getCodigo());
                cont = stmt.executeUpdate();
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();
            return cont;
        }
    }
    
    public int remover(int codigo){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "delete from cliente where codigo=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, codigo);
                cont = stmt.executeUpdate();
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();
            return cont;
        }
    }
    
    public Cliente pesquisarPorNome(String nome){
        Cliente obj = new Cliente(null, null, null, null, null, null);
        try{
            if(conexao.conectar()){
                String sql = "select * from cliente where nome=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, nome);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    obj.setCodigo(resultado.getLong("codigo"));
                    obj.setNome(resultado.getString("nome"));
                    obj.setEmail(resultado.getString("email"));
                    obj.setEndereco(resultado.getString("endereco"));
                    obj.setTelefone(resultado.getString("telefone"));
                    obj.setDatanasc(resultado.getString("datanasc"));
                    obj.setCPF(resultado.getString("CPF"));
                }
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();
            return obj;
        }
    }
    
        public Cliente pesquisarPorCodigo(int codigo){
        Cliente obj = new Cliente(null, null, null, null, null, null);
        try{
            if(conexao.conectar()){
                String sql = "select * from cliente where codigo=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setLong(1, codigo);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    obj.setCodigo(resultado.getLong("codigo"));
                    obj.setNome(resultado.getString("nome"));
                    obj.setEmail(resultado.getString("email"));
                    obj.setEndereco(resultado.getString("endereço"));
                    obj.setTelefone(resultado.getString("telefone"));
                    obj.setDatanasc(resultado.getString("datanasc"));
                    obj.setCPF(resultado.getString("CPF"));
                }
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();
            return obj;
        }
    }
    
    public List<Cliente> retornaLista(String busca){
        List<Cliente> lista = new ArrayList<Cliente>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(busca.length() > 0){          
                    stmt = conexao.preparedStatement("select *  from cliente "
                            + "where nome like ? order by codigo");
                    stmt.setString(1, "%"+ busca + "%");
                } else {
                    stmt = conexao.preparedStatement("select *  from cliente "
                            + "order by codigo");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                    Cliente obj = new Cliente(null, null, null, null, null, null);
                    obj.setCodigo(resultado.getLong("codigo"));
                    obj.setNome(resultado.getString("nome"));
                    obj.setEmail(resultado.getString("email"));
                    obj.setEndereco(resultado.getString("endereco"));
                    obj.setTelefone(resultado.getString("telefone"));
                    obj.setDatanasc(resultado.getString("datanasc"));
                    obj.setCPF(resultado.getString("CPF"));
                    lista.add(obj);
                }
            }
        } 
        catch(SQLException err){
         System.err.println(err.getMessage());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally{
            conexao.desconectar();
            return lista;
        }
    }    
}
