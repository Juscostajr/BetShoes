/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app;

import br.com.controller.ItensListController;
import br.com.controller.LoginController;
import br.com.model.Item;
import br.com.model.ItensPedido;
import br.com.model.Pedido;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juscelino Jr
 */
public class ServletFinalizarCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginController.estaLogado(request)) {

            try {
                String[] produto = request.getParameterValues("produto[]");
                String[] quantidade = request.getParameterValues("quantidade[]");

                Pedido pedido = new Pedido();
                pedido.getUsuario().setLogin(LoginController.getUsuario(request));
                pedido.insert();
                
                int codPedido = pedido.getLastIndex();

                for (int i = 0; i < produto.length; i++) {
                    ItensPedido itensPedido = new ItensPedido();
                    itensPedido.setItem(Integer.parseInt(produto[i]));
                    itensPedido.setPedido(codPedido);
                    itensPedido.setQuantidade(Integer.parseInt(quantidade[i]));
                    itensPedido.insert();
                    
                    System.out.println(produto[i]);
                    System.out.println(quantidade[i]);                   
                }
                
               
                HttpSession session = request.getSession(true);
                for (Item i : ItensListController.getItensList(request)){                  
                    session.removeAttribute(i.getCodigoString());
                }
                
                
                response.sendRedirect("./");
            } catch (SQLException ex) {
                Logger.getLogger(ServletFinalizarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            response.sendRedirect("login.jsp?from=./");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
