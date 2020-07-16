/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Quarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago e joao
 */
public class QuartoDAO {
    private ConexaoSQLite conexao = new ConexaoSQLite();

    public QuartoDAO(){
        try{
            String sql = 
                "CREATE TABLE IF NOT EXISTS quarto("
                    + "numero integer PRIMARY KEY,"
                    + "tipo varchar(60) NOT NULL,"
                    + "descricao varchar(60) NOT NULL,"
                    + "ocupado boolean NOT NULL,"
                    + "valorDiaria double NOT NULL)";
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
    
    public Quarto pesquisarPorTipo(String nome){
        Quarto obj = new Quarto(null, null, false, 0);
        try{
            if(conexao.conectar()){
                String sql = "select * from quarto where tipo=? and ocupado=false";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, nome);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    obj.setNumero(resultado.getInt("numero"));
                    obj.setTipo(resultado.getString("tipo"));
                    obj.setDescricao(resultado.getString("descricao"));
                    obj.setOcupado(resultado.getBoolean("ocupado"));
                    obj.setValorDiaria(resultado.getDouble("valorDiaria"));
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
    
    public void mudarStatus(Quarto obj){
        try{
        conexao.conectar();
        String mudar_status = "update quarto set ocupado=true "
                                      + "where numero=?";
        PreparedStatement stmt_s = conexao.preparedStatement(mudar_status);
        stmt_s.setLong(1, obj.getNumero());
        stmt_s.executeUpdate();
        }catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();
        }
    }

    public int inserir(Quarto obj){
        int cont = 0;
        try{
            if(conexao.conectar()){ 
                String sql = "insert into quarto(tipo,descricao,ocupado,valorDiaria)"
                        + " values(?,?,?,?)";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getTipo());
                stmt.setString(2, obj.getDescricao());
                stmt.setBoolean(3, obj.isOcupado());
                stmt.setDouble(4, obj.getValorDiaria());
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
    
    public int alterar(Quarto obj){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update quarto set tipo=?,descricao=?,ocupado=?,valorDiaria=?"
                        + "where numero=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, obj.getTipo());
                stmt.setString(2, obj.getDescricao());
                stmt.setBoolean(3, obj.isOcupado());
                stmt.setDouble(4, obj.getValorDiaria());
                stmt.setLong(5, obj.getNumero());
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
                String sql = "delete from quarto where numero=? cascade constraints";
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
    
    public Quarto pesquisarPorNumero(int numero){
        Quarto obj = new Quarto(null, null, false, 0);
        try{
            if(conexao.conectar()){
                String sql = "select * from quarto where numero=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, numero);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    obj.setNumero(resultado.getInt("numero"));
                    obj.setTipo(resultado.getString("tipo"));
                    obj.setDescricao(resultado.getString("descricao"));
                    obj.setOcupado(resultado.getBoolean("ocupado"));
                    obj.setValorDiaria(resultado.getDouble("valorDiaria"));
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
    
    
    public List<Quarto> retornaLista(String busca){
        List<Quarto> lista = new ArrayList<>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(busca.length() > 0){          
                    stmt = conexao.preparedStatement("select *  from quarto "
                            + "where tipo like ? order by numero");
                    stmt.setString(1, "%"+ busca + "%");
                } else {
                    stmt = conexao.preparedStatement("select *  from quarto "
                            + "order by numero");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                    Quarto obj = new Quarto(null, null, false, 0);
                    obj.setNumero(resultado.getInt("numero"));
                    obj.setTipo(resultado.getString("tipo"));
                    obj.setDescricao(resultado.getString("descricao"));
                    obj.setOcupado(resultado.getBoolean("ocupado"));
                    obj.setValorDiaria(resultado.getDouble("valorDiaria"));
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
