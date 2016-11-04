/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app;

import br.com.model.Usuario;
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
public class ServletUsuario extends HttpServlet {

 
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
            Usuario usuario = new Usuario();
            
            Boolean admin = request.getParameter("admin") != null;
            usuario.setLogin(request.getParameter("usuario"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setAdmin(admin);
  
             try {
            usuario.insert();
            
            response.sendRedirect("./login.jsp?from=./");
        } catch (SQLException ex) {
            Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
