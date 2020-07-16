/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.Atendente;
import DTO.Hospedagem;
import DTO.Nota;
import DTO.Quarto;
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

public class HospedagemDAO {
private ConexaoSQLite conexao = new ConexaoSQLite();

    public HospedagemDAO(){
        try{
            String sql = 
                "CREATE TABLE IF NOT EXISTS hospedagem("
                    + "codigo integer PRIMARY KEY AUTOINCREMENT,"
                    + "diarias varchar(60) NOT NULL,"
                    + "valorTotal number(7,2) NOT NULL, "
                    + "notaFiscal int NOT NULL,"
                    + "FOREIGN KEY(notaFiscal) REFERENCES nota(numero))";
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
    
    public int inserir(Hospedagem obj){
        int cont = 0;
        try{
            if(conexao.conectar()){ 
                String sql = "insert into hospedagem(diarias,valorTotal,notaFiscal)"
                        + " values(?,?,?)";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, obj.getDiarias());
                stmt.setDouble(2, obj.getValorTotal());
                stmt.setLong(3, obj.getNotafiscal().getNumero());
    
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
    
    public int alterar(Hospedagem obj){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update hospedagem set diarias=?,valorTotal=?,notaFiscal=?"
                        + "where codigo=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, obj.getDiarias());
                stmt.setDouble(2, obj.getValorTotal());
                stmt.setLong(3, obj.getNotafiscal().getNumero());
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
                String sql = "delete from hospedagem where codigo=?";
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
    
    public Hospedagem pesquisarPorNome(int numero){
        Hospedagem obj = new Hospedagem(null, null, null, null, 0, false);
        try{
            if(conexao.conectar()){
                String sql = "select * from hospedagem where numero=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, numero);
                ResultSet resultado = stmt.executeQuery();
                
                if(! resultado.isClosed()){
                    PreparedStatement n = conexao.preparedStatement(
                        "SELECT * FROM nota WHERE numero=?"
                        );
                    n.setLong(1, resultado.getLong("numero"));
                    ResultSet r_nota = n.executeQuery();

                    Nota n1 = new Nota(
                                        r_nota.getString("dataEmissao"),
                                        r_nota.getDouble("valor")
                                        );

                    obj.setCodigo(resultado.getLong("codigo"));
                    obj.setDiarias(Integer.parseInt(resultado.getString("diarias")));
                    obj.setValorTotal(Double.parseDouble(resultado.getString("valorTotal")));
                    obj.setNotafiscal(n1);
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

    public List<Hospedagem> retornaLista(int busca){
        List<Hospedagem> lista = new ArrayList<>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(busca > 0){          
                    stmt = conexao.preparedStatement("select *  from hospedagem "
                            + "where numero like ? order by numero");
                    stmt.setInt(1, busca);
                } else {
                    stmt = conexao.preparedStatement("select * from hospedagem "
                            + "order by numero");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                    Hospedagem obj = new Hospedagem(null, null, null, null, 0, false);
                    
                    
                    PreparedStatement n = conexao.preparedStatement(
                        "SELECT * FROM nota WHERE numero=?"
                        );
                    n.setLong(1, resultado.getLong("numero"));
                    ResultSet r_nota = n.executeQuery();

                    Nota n1 = new Nota(
                                        r_nota.getString("dataEmissao"),
                                        r_nota.getDouble("valor")
                                        );

                    obj.setCodigo(resultado.getLong("codigo"));
                    obj.setDiarias(Integer.parseInt(resultado.getString("diarias")));
                    obj.setValorTotal(Double.parseDouble(resultado.getString("valorTotal")));
                    obj.setNotafiscal(n1);
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