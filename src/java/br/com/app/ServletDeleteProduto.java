/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app;

import br.com.model.Item;
import br.com.model.ItensPedido;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juscelino Jr
 */
public class ServletDeleteProduto extends HttpServlet {

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Item item = new Item();
        ItensPedido itens = new ItensPedido();
        String id = request.getParameter("id");
        
        try {
            itens.deleteComProduto(id);
            item.delete(id, item.getPrimaryKey(), item.getTabela());
            response.sendRedirect("./admin/?pg=editar");           
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
