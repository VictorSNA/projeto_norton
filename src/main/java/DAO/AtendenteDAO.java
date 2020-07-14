/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
                    + "codigo integer PRIMARY KEY,"
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
    
    public int inserir(Recepcionista obj){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "insert into recepcionista(nome,telefone,senha,cpf)"
                        + " values(?,?,?,?)";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getTelefone());
                stmt.setString(3, obj.getSenha());
                stmt.setString(4, obj.getCpf());
                
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
    
    public int alterar(Recepcionista obj){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update recepcionista set nome=?,telefone=?,senha=?,"
                        + "cpf=? where nome=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getTelefone());
                stmt.setString(3, obj.getSenha());
                stmt.setString(4, obj.getCpf());
                stmt.setString(5, obj.getNome());
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
    
    public int remover(String nome){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "delete from recepcionista where nome=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, nome);
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
    
    public Recepcionista pesquisar(String nome){
        Recepcionista obj = new Recepcionista();
        try{
            if(conexao.conectar()){
                String sql = "select * from recepcionista where nome=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, nome);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    obj.setTelefone(resultado.getString("telefone"));
                    obj.setNome(resultado.getString("nome"));
                    obj.setSenha(resultado.getString("senha"));
                    obj.setCpf(resultado.getString("cpf"));
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
    
    public List<Recepcionista> retornaLista(String busca){
        List<Recepcionista> lista = new ArrayList<Recepcionista>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(busca.length() > 0){          
                    stmt = conexao.preparedStatement("select *  from recepcionista "
                            + "where nome like ? order by nome");
                    stmt.setString(1, "%"+ busca + "%");
                } else {
                    stmt = conexao.preparedStatement("select *  from recepcionista "
                            + "order by nome");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                    Recepcionista obj = new Recepcionista();
                    obj.setTelefone(resultado.getString("telefone"));
                    obj.setNome(resultado.getString("nome"));
                    obj.setSenha(resultado.getString("senha"));
                    obj.setCpf(resultado.getString("cpf"));
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
