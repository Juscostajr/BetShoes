<%-- 
    Document   : edt_produto
    Created on : 02/11/2016, 19:56:04
    Author     : Juscelino Jr
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Item item = new Item(); 
ResultSet rs = item.fetchAll(); %>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Código</th>
            <th>Descrição</th>
            <th>Quantidade</th>
            <th>Valor</th>
            <th>Ação</th>
        </tr>
        </thead>
        <tbody>
            <% while(rs.next()){ %>
            <tr>
                <td><%= rs.getString("CD_ITEM") %></td>
                <td><%= rs.getString("DS_ITEM") %></td>
                <td><%= rs.getString("QT_ITEM") %></td>
                <td><%= rs.getString("VL_ITEM") %></td>
                <td>
                    <button type='button' class='btn btn-warning btn-xs' onClick='window.location = "./?pg=alterar&id=<%= rs.getString("CD_ITEM") %>"'><span class='glyphicon glyphicon-edit'></span></button>
                    <button type='button' class='btn btn-danger btn-xs' onClick='window.location = "../ServletDeleteProduto?id=<%= rs.getString("CD_ITEM") %>"'><span class='glyphicon glyphicon-trash'></span></button>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
