<%-- 
    Document   : listaProdutos
    Created on : 19/10/2016, 20:06:17
    Author     : Juscelino Jr
--%>

<%@page import="br.com.controller.LoginController"%>
<%@page import="br.com.controller.ItensListController"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Item item = new Item();
    ResultSet rs = item.fetchAll(); %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bet Shoes</title>
        <!-- JS -->
        <script type="text/javascript" src="js/lib/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/lib/bootstrap.min.js"></script>

        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/custom.css">

    </head>
    <body>
        <header>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Bet <b>Shoes</b></a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">                      
                        <% if(LoginController.estaLogado(request)){  %>
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%= LoginController.getUsuario(request) %></a></li>
                        <li><a href="ServletLogOut"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                        <% } else { %>
                        <li><a href="./cadastro.jsp"><span class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
                        <li><a href="login.jsp?from=./"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        <% } %>
                    </ul>
                </div>
            </nav>

            <div id="consulta">
                <div class="container">
                    <div class="input-group">
                        <input type="text" class="form-control" id="valorConsulta">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-warning" id="novaConsulta"><span class="glyphicon glyphicon-search"></span> </button>
                        </span>
                    </div>
                </div>
            </div>
        </header>
        <div id="resultadoConsulta" class="container"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="carousel slide multi-item-carousel" id="theCarousel">
                        <div class="carousel-inner">
                            <% int i = 0; %>
                            <% while (rs.next()) {
                                    i++;%>

                            <div class="<%= (i == 1 ? "item active" : "item")%>">
                                <div class="col-xs-4 text-center"><a href="#1"><img src="img/<%= rs.getString("CD_ITEM")%>.jpg" class="img-responsive" width="300" height="300"></a>
                                    <ul class="list-group">
                                        <li class="list-group-item"><%= rs.getString("DS_ITEM")%></li>
                                        <li class="list-group-item"><b>R$ <%= rs.getString("VL_ITEM")%></b></li>
                                        <li class="list-group-item">Disponíveis: <%= rs.getString("QT_ITEM")%></li>
                                    </ul>
                                    <button class="btn btn-success item-shop" data-item-id="<%= rs.getString("CD_ITEM")%>">
                                        <span class="glyphicon glyphicon-plus"></span> Adicionar ao Carrinho
                                    </button>
                                </div>
                            </div>


                            <% }%>

                            <!--  Example item end -->
                        </div>
                        <a class="left carousel-control" href="#theCarousel" data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i></a>
                        <a class="right carousel-control" href="#theCarousel" data-slide="next"><i class="glyphicon glyphicon-chevron-right"></i></a>
                    </div>
                </div>
            </div>
        </div>   

        <!-- botão carrinho de compras -->
        <button type="button" class="btn btn-info btn-circle btn-xl" id="btn-shopping-cart" data-toggle="modal" data-target="#modal"><i class="glyphicon glyphicon-shopping-cart"></i><span id ="shopping-cart-count"><%= ItensListController.getItensCount(request)%></span></button>

        <!-- modal finalizar compra -->
        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">


                    <div class="modal-header">

                        <div class="row">
                            <div class="col-xs-6">
                                <h5><span class="glyphicon glyphicon-shopping-cart"></span> Meu carrinho de compras</h5>
                            </div>
                            <div class="col-xs-6">
                                <button type="button" class="btn btn-info btn-sm btn-block" data-dismiss="modal" aria-label="Close">
                                    <span class="glyphicon glyphicon-share-alt"></span> Continuar comprando
                                </button>
                            </div>
                        </div>
                    </div>

                    <div id="carrinho"></div>

                </div><!-- /.modal-content -->
            </div>
        </div>
        <footer></footer>
        <script type="text/javascript" src="js/app.js"></script>
    </body>
</html>