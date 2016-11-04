/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app;

import br.com.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juscelino Jr
 */
public class ServletAlterarProduto extends HttpServlet {


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            Item item = new Item(); 
            item.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            item.setDescricao(request.getParameter("descricao"));
            item.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            item.setValor(Double.parseDouble(request.getParameter("valor")));
            item.update();
                response.sendRedirect("./admin/?pg=editar");
        } catch (SQLException ex) {
            Logger.getLogger(ServletAlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
