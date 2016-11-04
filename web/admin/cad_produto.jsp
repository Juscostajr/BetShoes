<%-- 
    Document   : cad_produto
    Created on : 02/11/2016, 20:00:24
    Author     : Juscelino Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="../ServletProduto" method="post">    
    <br/>
    <div class="form-group">
        <input id="descricao" name="descricao" type="text" placeholder="descreva o produto" class="form-control input-md" required>                 
    </div>
    <div class="form-group">
        <input id="quantidade" name="quantidade" type="number" placeholder="informe a quantidade em estoque" class="form-control input-md" required>
    </div>
    <div class="form-group">
        <input type="file" id="img" name="img" class='file' data-show-preview='true'>
    </div> 
    <div class="form-group">
        <input id="valor" name="valor" type="number" step="0.01" placeholder="descreva o valor do produto" class="form-control input-md" required>
    </div>                   
    <div class="form-group">
        <input type="submit" value="Cadastrar" class="form-control btn btn-success"/>
    </div>
</form>