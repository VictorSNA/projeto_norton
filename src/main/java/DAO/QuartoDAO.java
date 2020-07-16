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
 * @author Thiago
 */
public class QuartoDAO {
    private ConexaoSQLite conexao = new ConexaoSQLite();

    public QuartoDAO(){
        try{
            String sql = 
                "CREATE TABLE IF NOT EXISTS atendente("
                    + "numero integer PRIMARY KEY,"
                    + "tipo varchar(60) NOT NULL,"
                    + "descricao varchar(60) NOT NULL, "
                    + "ocupado boolean NOT NULL"
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
}

