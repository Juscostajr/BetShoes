/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app;

import br.com.controller.ImageController;
import com.google.gson.Gson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Juscelino Jr
 */
@MultipartConfig
public class ServletImagem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //image upload
        ImageController img = new ImageController(request);
        try{
        img.delete("img/temp.jpg");
        } catch (Exception e){
        img.saveFromUpload("img","img/temp.jpg");
        }
        
        //json return
        String json = new Gson().toJson(new String[0]);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
