/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Atendente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victo
 */
public class AtendenteDAO {
private ConexaoSQLite conexao = new ConexaoSQLite();

    public AtendenteDAO(){
        try{
            String sql = 
                "CREATE TABLE IF NOT EXISTS atendente("
                    + "codigo integer PRIMARY KEY AUTOINCREMENT,"
                    + "nome varchar(60) NOT NULL,"
                    + "email varchar(60) NOT NULL, "
                    + "senha varchar(30) NOT NULL)";
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
    
    public int inserir(Atendente obj){
        int cont = 0;
        try{
            if(conexao.conectar()){ 
                String sql = "insert into atendente(nome,email,senha)"
                        + " values(?,?,?)";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getEmail());
                stmt.setString(3, obj.getSenha());
                
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
    
    public int alterar(Atendente obj){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update atendente set nome=?,email=?,senha=?"
                        + "where codigo=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getEmail());
                stmt.setString(3, obj.getSenha());
                stmt.setLong(4, obj.getCodigo());
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
                String sql = "delete from atendente where codigo=?";
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
    
    public Atendente pesquisarPorNome(String nome){
        Atendente obj = new Atendente(null, null, null);
        try{
            if(conexao.conectar()){
                String sql = "select * from atendente where nome=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, nome);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    obj.setCodigo(resultado.getLong("codigo"));
                    obj.setNome(resultado.getString("nome"));
                    obj.setEmail(resultado.getString("email"));
                    obj.setSenha(resultado.getString("senha"));
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
    
        public Atendente pesquisarPorCodigo(int codigo){
        Atendente obj = new Atendente(null, null, null);
        try{
            if(conexao.conectar()){
                String sql = "select * from atendente where codigo=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setLong(1, codigo);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    obj.setCodigo(resultado.getLong("codigo"));
                    obj.setNome(resultado.getString("nome"));
                    obj.setEmail(resultado.getString("email"));
                    obj.setSenha(resultado.getString("senha"));
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
    
    public List<Atendente> retornaLista(String busca){
        List<Atendente> lista = new ArrayList<Atendente>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(busca.length() > 0){          
                    stmt = conexao.preparedStatement("select *  from atendente "
                            + "where nome like ? order by codigo");
                    stmt.setString(1, "%"+ busca + "%");
                } else {
                    stmt = conexao.preparedStatement("select *  from atendente "
                            + "order by codigo");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                    Atendente obj = new Atendente(null, null, null);
                    obj.setCodigo(resultado.getLong("codigo"));
                    obj.setNome(resultado.getString("nome"));
                    obj.setSenha(resultado.getString("senha"));
                    obj.setEmail(resultado.getString("email"));
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
