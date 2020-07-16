/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cliente;
import DTO.Quarto;
import DTO.Reserva;
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
public class ReservaDAO {
private ConexaoSQLite conexao = new ConexaoSQLite();

    public ReservaDAO(){
        try{
            String sql = 
                "CREATE TABLE IF NOT EXISTS reserva("
                    + "codigo integer PRIMARY KEY AUTOINCREMENT,"
                    + "quarto int NOT NULL,"
                    + "cliente int NOT NULL, "
                    + "datain varchar(30) NOT NULL,"
                    + "dataout varchar(30) NOT NULL,"
                    + "valor number(10) NOT NULL,"
                    + "pago boolean NOT NULL,"
                    + "FOREIGN KEY(quarto) REFERENCES quarto(numero),"
                    + "FOREIGN KEY(cliente) REFERENCES cliente(codigo))";
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
    
    public int inserir(Reserva obj){
        int cont = 0;
        try{
            if(conexao.conectar()){ 
                String sql = "insert into reserva(quarto,cliente,datain,"
                        + "dataout,valor,pago)"
                        + " values(?,?,?,?,?,?)";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, obj.getQuarto().getNumero());
                stmt.setLong(2, obj.getCliente().getCodigo());
                stmt.setString(3, obj.getDatain());
                stmt.setString(4, obj.getDataout());
                stmt.setDouble(5, obj.getValor());
                stmt.setBoolean(5, obj.isPago());
                
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
    
    public int alterar(Reserva obj){
        int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update reserva set quarto=?,cliente=?,datain=?,"
                        + "dataout=?,valor=?,pago=?"
                        + "where codigo=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setInt(1, obj.getQuarto().getNumero());
                stmt.setLong(2, obj.getCliente().getCodigo());
                stmt.setString(3, obj.getDatain());
                stmt.setString(4, obj.getDataout());
                stmt.setDouble(5, obj.getValor());
                stmt.setBoolean(6, obj.isPago());
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
                String sql = "delete from reserva where codigo=?";
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
    
    public Reserva pesquisarPorNome(String nome){
        Reserva obj = null;

        try{
            if(conexao.conectar()){
                String sql = "select * from reserva where codigo=?";
                PreparedStatement stmt = conexao.preparedStatement(sql);
                stmt.setString(1, nome);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                    PreparedStatement q = conexao.preparedStatement(
                        "SELECT * FROM quarto WHERE numero=?"
                        );
                    q.setLong(1, resultado.getLong("codigo"));
                    ResultSet r_quarto = q.executeQuery();

                    PreparedStatement c = conexao.preparedStatement(
                        "SELECT * FROM cliente WHERE numero=?"
                        );
                    c.setInt(1, resultado.getInt("numero"));
                    ResultSet r_cliente = c.executeQuery();
                    
                    Quarto q1 = new Quarto(
                                r_quarto.getInt("numero"),
                                r_quarto.getString("tipo"),
                                r_quarto.getString("descricao"),
                                r_quarto.getBoolean("ocupado"),
                                r_quarto.getDouble("valorDiaria"));
                    Cliente c1 = new Cliente(
                                r_cliente.getString("nome"),
                                r_cliente.getString("email"),
                                r_cliente.getString("endereco"),
                                r_cliente.getString("telefone"),
                                r_cliente.getString("data_nasc"),
                                r_cliente.getString("cpf"));

                    obj = new Reserva(
                        q1,
                        c1,
                        resultado.getString("datain"),
                        resultado.getString("dataout"),
                        resultado.getFloat("valor"),
                        resultado.getBoolean("pago")
                    );
                    
                    obj.setCodigo(resultado.getLong("numero"));
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
    
    public List<Reserva> retornaLista(String busca){
        List<Reserva> lista = new ArrayList<>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(busca.length() > 0){          
                    stmt = conexao.preparedStatement("select *  from reserva "
                            + "where codigo like ? order by codigo");
                    stmt.setString(1, "%"+ busca + "%");
                } else {
                    stmt = conexao.preparedStatement("select *  from reserva "
                            + "order by codigo");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                    Reserva obj = new Reserva(null,null,null,null,0,false);
                    stmt.setInt(1, obj.getQuarto().getNumero());
                    stmt.setLong(2, obj.getCliente().getCodigo());
                    stmt.setString(3, obj.getDatain());
                    stmt.setString(4, obj.getDataout());
                    stmt.setDouble(5, obj.getValor());
                    stmt.setBoolean(5, obj.isPago());
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
