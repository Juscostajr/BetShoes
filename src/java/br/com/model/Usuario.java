/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juscelino Jr
 */
public class Usuario extends Dao {
    
    private String login;
    private String senha;
    private String cpf;
    private int domicilio;
    private int cep;
    private String nome;
    private Date nascimento;
    private String tabela = "usuario";
    private Boolean admin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    @Override
    public Boolean insert() throws SQLException {
        query = "INSERT INTO usuario (DS_LOGIN, DS_SENHA,ADMIN) VALUES(?,?,?)";
        stmt = getConexaoMySQL().prepareStatement(query);
        stmt.setString(1, login);
        stmt.setString(2, senha);
        stmt.setInt(3, admin ? 1 :0);
        return stmt.execute();
    }

    @Override
    Boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ResultSet fetchAll() throws SQLException {
            return findAll(this.tabela);
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public int getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(int domicilio) {
        this.domicilio = domicilio;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
