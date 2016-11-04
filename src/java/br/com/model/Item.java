/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juscelino Jr
 */
public class Item extends Dao {
    
    private String tabela = "item";
    private String primaryKey = "CD_ITEM";
    private int codigo;
    private String descricao;
    private int quantidade;
    private Double valor;

    public String getPrimaryKey() {
        return primaryKey;
    }
    

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getCodigo() throws SQLException {
        PreparedStatement stmt = getConexaoMySQL().prepareStatement("SELECT max(CD_ITEM) as MAX FROM item");
            ResultSet value = stmt.executeQuery();
            value.first();
            return String.format("%06d", Integer.parseInt(value.getString("MAX")));
    }
    
public String getCodigoString() {
    return String.format("%06d",codigo);
}

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
      @Override
    public Boolean insert()throws SQLException {
        String query = "INSERT INTO item (DS_ITEM, QT_ITEM, VL_ITEM) VALUES (?,?,?)";
        PreparedStatement stmt = getConexaoMySQL().prepareStatement(query);
        stmt.setString(1, this.getDescricao());
        stmt.setInt(2, this.getQuantidade());
        stmt.setDouble(3, this.getValor());
        return stmt.execute();
    }

    @Override
    public Boolean update() throws SQLException {
        query = "UPDATE item SET DS_ITEM = ? , QT_ITEM = ? , VL_ITEM = ? WHERE CD_ITEM = ?";
        
        stmt = getConexaoMySQL().prepareStatement(query);
        stmt.setString(1, descricao);
        stmt.setInt(2, quantidade);
        stmt.setDouble(3, valor);
        stmt.setInt(4, codigo);
        System.out.println(query);
        return stmt.execute();
    }

   
    @Override
    public ResultSet fetchAll() throws SQLException {
        return findAll(this.tabela);
    }
    
    public Item fetchId(int id) throws SQLException{
        String query = "SELECT * FROM item WHERE CD_ITEM = ?";
        PreparedStatement stmt = getConexaoMySQL().prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.first();
        this.codigo =  rs.getInt("CD_ITEM");
        this.descricao = rs.getString("DS_ITEM");
        this.valor = Double.parseDouble(rs.getString("VL_ITEM"));
        this.quantidade = Integer.parseInt(rs.getString("QT_ITEM"));
        return this; 
    }
    
    public ResultSet fetchLike() throws SQLException{
        query = "SELECT * FROM item WHERE DS_ITEM LIKE ?";
        stmt = getConexaoMySQL().prepareStatement(query);
        stmt.setString(1, "%" + descricao + "%");
        return stmt.executeQuery();
    }
}
