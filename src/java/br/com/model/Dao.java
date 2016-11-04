/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.conexao.Mysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Juscelino Jr
 */
public abstract class Dao extends Mysql {
   
    String query;
    PreparedStatement stmt;
    
  
    abstract Boolean insert() throws SQLException;
    abstract Boolean update() throws SQLException;
    abstract ResultSet fetchAll() throws SQLException;
    
    
    
    
    public Boolean delete(String id, String primaryKey, String tabela) throws SQLException{
        
        query = "DELETE FROM " + tabela + " WHERE " + primaryKey + " = " + id;      
            stmt = getConexaoMySQL().prepareStatement(query);
            return stmt.execute();
       
    }
    
    
    
    public ResultSet findAll(String tabela) throws SQLException{
        query = "SELECT * FROM " + tabela;
        stmt = getConexaoMySQL().prepareStatement(query);
        return stmt.executeQuery();
    }
}
