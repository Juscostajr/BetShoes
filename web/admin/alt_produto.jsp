<%-- 
    Document   : alt_produto
    Created on : 02/11/2016, 20:15:26
    Author     : Juscelino Jr
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Item item = new Item(); 
item = item.fetchId(Integer.parseInt(request.getParameter("id"))); %>

<form action="../ServletAlterarProduto" method="post">    
    <input type="hidden" name="codigo" value="<%= item.getCodigoString()%>">
    <br/>
    <div class="form-group">     
        <label>Produto</label>
        <input id="descricao" name="descricao" type="text" value="<%= item.getDescricao() %>" placeholder="descreva o produto" class="form-control input-md" required>                 
    </div>
    <div class="form-group">
        <label>Quantidade</label>
        <input id="quantidade" name="quantidade" type="text" value="<%= item.getQuantidade() %>" placeholder="informe a quantidade em estoque" class="form-control input-md" required>
    </div>
    <div class="form-group">
        <label>Valor (R$)</label>
        <input id="valor" name="valor" type="text" value="<%= item.getValor() %>" placeholder="descreva o valor do produto" class="form-control input-md" required>
    </div>                   
    <div class="form-group">
        <input type="submit" value="Alterar" class="form-control btn btn-success"/>
    </div>
</form>
