/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Juscelino Jr
 */
public class PaginaCadastroController {

    
    
    public static String getPagina(HttpServletRequest request) {
        String pagina;
        try {
        pagina = request.getParameter("pg");
        
        
        switch (pagina) {
            case "cadastrar":
                return "cad_produto.jsp";
            case "editar":
                return "edt_produto.jsp";
            case "alterar":
                return "alt_produto.jsp";
            default:
                return "edt_produto.jsp";
        }

        } catch (Exception e){
        return "edt_produto.jsp";    
        }
    }

}
