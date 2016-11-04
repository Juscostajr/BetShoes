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
public class Pedido extends Dao {

    private Integer codigo;
    private Usuario usuario = new Usuario();

    @Override
    public Boolean insert() throws SQLException {
        query = "INSERT INTO pedido (USUARIO_DS_LOGIN) VALUES (?)";
        stmt = getConexaoMySQL().prepareStatement(query);
        stmt.setString(1, usuario.getLogin());
        return stmt.execute();
    }

    public Integer getLastIndex() throws SQLException {
        PreparedStatement stmt = getConexaoMySQL().prepareStatement("SELECT max(CD_PEDIDO) as MAX FROM pedido");
        ResultSet value = stmt.executeQuery();
        value.first();
        return Integer.parseInt(value.getString("MAX"));
    }

    @Override
    Boolean update() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    ResultSet fetchAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

}
