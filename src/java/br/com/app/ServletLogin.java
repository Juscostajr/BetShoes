package br.com.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.controller.LoginController;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String destino = request.getParameter("from");

        if (LoginController.login(usuario, senha)) {
            response.addCookie(LoginController.getCookie("usuario", usuario));
            response.addCookie(LoginController.getCookie("senha", senha));

            response.sendRedirect("/BetShoes/" + destino);
        } else {
            response.sendRedirect("/BetShoes/");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
