<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>E-Commerce</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <div class="account-wall">
                    <img class="profile-img" src="img/profile.jpg" alt="">
                    <form class="form-signin" action="ServletUsuario" method="POST">
                        <input type="hidden" name="from" value="<%= request.getParameter("from") %>">
                        <input type="text" class="form-control" placeholder="Seu nome de usuário" name="usuario" autofocus required>
                        <input type="password" class="form-control" placeholder="Sua senha" name="senha" required>                       
                        <div class="text-right">
                        <label class="checkbox-inline">
                        <input type="checkbox" name="admin" value="true" />
                        Administrador?</label></div><br>
                        <button class="btn btn-lg btn-danger btn-block" type="submit">Cadastrar</button>
                    </form>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/app.js"></script>
    </body>
</html>