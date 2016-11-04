/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juscelino Jr
 */
public class ItensPedido extends Dao{
    
    private Integer item;
    private Integer pedido;
    private Integer quantidade;

    
   
    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public Boolean insert() throws SQLException {
        query = "INSERT INTO itens_pedido (ITEM_CD_ITEM, PEDIDO_CD_PEDIDO, QT_ITENS) VALUES (?,?,?)";
        stmt = getConexaoMySQL().prepareStatement(query);
        stmt.setInt(1, item);
        stmt.setInt(2, pedido);
        stmt.setInt(3, quantidade);
        return stmt.execute();
    }

    @Override
    Boolean update() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    ResultSet fetchAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Boolean deleteComProduto(String id) throws SQLException{
        query = "DELETE FROM itens_pedido WHERE ITEM_CD_ITEM = " + id;
        stmt = getConexaoMySQL().prepareStatement(query);
        return stmt.execute();
    }
    
}
