/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Juscelino Jr
 */
public class ImageController {
    private HttpServletRequest request;

    public ImageController() {}
    
    public ImageController(HttpServletRequest request) {
        this.request = request;
    }
    
    
    
      public InputStream loadFromFile(String path) throws IOException, ServletException{
        return new FileInputStream(setPath(path).toString());
    }
    
    public InputStream loadFromUpload(String imgParamName) throws IOException, ServletException{
        Part filePart = this.request.getPart(imgParamName);
        return filePart.getInputStream(); 
    }
    
    public Path getPath(){
        String root = this.request.getServletContext().getRealPath("/");
        return Paths.get(root).getParent().getParent().resolve("web"); 
    }
    
    public Path setPath(String path){ 
    return getPath().resolve(path);
    }
    public void saveFromUpload(String imageParamenter, String path) throws IOException, ServletException{      
        InputStream fileContent = loadFromUpload(imageParamenter);       
        save(fileContent, path);
        
    }
    
    public void save(InputStream fileContent, String path) throws IOException, ServletException{          
        Path destination = setPath(path);
        Files.copy(fileContent, destination);
        fileContent.close();
    }
 
    
    public Boolean imgExists(String path){
        String uri = setPath(path).toString();
       return new File(uri).isFile();
    }
    
    public void delete(String path) throws IOException{
        Files.delete(setPath(path));
    }
    
    public void rename(String origin, String dest) throws IOException, ServletException {
        InputStream old = loadFromFile(origin);
        origin = setPath(origin).toString();
        dest = setPath(dest).toString();
        save(old, dest);
        delete(origin);
    }
}
