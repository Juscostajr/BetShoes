package br.com.app;

import br.com.controller.ImageController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.model.Item;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServletProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Load or List*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        Item item = new Item();

        item.setDescricao(request.getParameter("descricao"));
        item.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        item.setValor(Double.parseDouble(request.getParameter("valor")));

        try {

            ImageController img = new ImageController(request);
            item.insert();
            img.rename("img/temp.jpg", "img/" + item.getCodigo() + ".jpg");
            response.sendRedirect("./admin/?pg=editar");
        } catch (Exception ex) {
            Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Update*/
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Delete*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
