/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Nota;
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
public class NotaDAO {
    private ConexaoSQLite conexao = new ConexaoSQLite();

    public NotaDAO(){
        try{
            String sql = 
                "CREATE TABLE IF NOT EXISTS nota("
                    + "numero integer PRIMARY KEY AUTOINCREMENT,"
                    + "dataEmissao varchar(60) NOT NULL,"
                    + "valor varchar(60) NOT NULL)";
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
    
    public int inserir(DTO.Nota obj){
        int cont = 0;
        try{
            if(conexao.conectar()){ 
                String sql = "insert into nota(dataEmissao, valor)"
                        + " values(?,?)";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getDataEmissao());
                stmt.setDouble(2, obj.getValor());

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
    
    public int alterar(DTO.Nota obj){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update nota set dataEmissao=?,valor=?"
                        + "where numero=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getDataEmissao());
                stmt.setDouble(2, obj.getValor());
                stmt.setLong(3, obj.getNumero());
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
    
    public int remover(int numero){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "delete from nota where numero=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, numero);
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
    
    public DTO.Nota pesquisar(int numero){
        DTO.Nota obj = new DTO.Nota(null, 0);
        try{
            if(conexao.conectar()){
                String sql = "select * from nota where numero=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, numero);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    obj.setNumero(resultado.getLong("numero"));
                    obj.setDataEmissao(resultado.getString("dataEmissao"));
                    obj.setValor(resultado.getDouble("valor"));
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

    public List<DTO.Nota> retornaLista(int busca){
        List<DTO.Nota> lista = new ArrayList<>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(busca > 0){          
                    stmt = conexao.preparedStatement("select *  from nota "
                            + "where numero like ? order by numero");
                    stmt.setLong(1, busca);
                } else {
                    stmt = conexao.preparedStatement("select *  from nota "
                            + "order by numero");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                    Nota obj = new Nota(null, 0);
                    obj.setNumero(resultado.getLong("numero"));
                    obj.setDataEmissao(resultado.getString("dataEmissao"));
                    obj.setValor(resultado.getDouble("valor"));
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
