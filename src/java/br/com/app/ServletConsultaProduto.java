/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app;

import br.com.model.Item;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juscelino Jr
 */
@WebServlet(name = "ServletConsultaProduto", urlPatterns = {"/ServletConsultaProduto"})
public class ServletConsultaProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String consulta = request.getParameter("consulta");
            Item item = new Item();
            item.setDescricao(consulta);
            ArrayList<Item> itens = new ArrayList();
            ResultSet rs = item.fetchLike();
            while (rs.next()) {
                Item novoitem = new Item();
                novoitem.setCodigo(rs.getInt("CD_ITEM"));
                novoitem.setDescricao(rs.getString("DS_ITEM"));
                novoitem.setQuantidade(rs.getInt("QT_ITEM"));
                novoitem.setValor(rs.getDouble("VL_ITEM"));
                itens.add(novoitem);
            }
            Gson gson = new Gson();
            String itemGson = gson.toJson(itens);
            
            PrintWriter out = response.getWriter();
            out.print(itemGson);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletConsultaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
