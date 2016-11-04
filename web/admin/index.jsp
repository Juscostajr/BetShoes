<%@page import="br.com.controller.PaginaCadastroController"%>
<%@ page import="br.com.model.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin</title>
        <meta charset="utf-8">
        <script type="text/javascript" src="../js/lib/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
        <script src="../js/fileinput.min.js"></script>
        <script src="../js/fileinput_locale_pt-BR.js"></script>

        <!-- CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/reset.css">
        <link rel="stylesheet" href="../css/normalize.css">
        <link href="../css/fileinput.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">               
                <div class="col-md-12">
                    <h1 class="page-header">Cadastro de Produtos</h1>
                    <ul class="nav nav-tabs">
                        <li id="editar"><a href="./?pg=editar"><span class="glyphicon glyphicon-edit"></span> Editar Produto</a></li>
                        <li id="cadastrar"><a href="./?pg=cadastrar"><span class="glyphicon glyphicon-plus"></span> Novo Produto</a></li>
                    </ul>
                    <jsp:include page="<%= PaginaCadastroController.getPagina(request)%>" flush="true" />


                </div>
            </div>
        </div>
        <script type="text/javascript">

            var upload = false;
            $("#img").fileinput({
                language: "pt-BR",
                showUpload: true,
                allowedFileExtensions: ["jpg", "png", "gif"],
                uploadUrl: "../ServletImagem",
                uploadAsync: true,
                maxFileCount: 1,
                showCaption: false
            });

            $(document).ready(function () {
                $("#<%= request.getParameter("pg")%>").attr("class", "active");
            });
        </script>
    </body>
</html>

