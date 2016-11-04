/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.Item;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juscelino Jr
 */
public class ItensListController {

    public static int getItensCount(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        Enumeration e = session.getAttributeNames();

        return Collections.list(e).size();
    }

    public static ArrayList<Item> getItensList(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(true);
        Enumeration e = session.getAttributeNames();
        ArrayList<String> id = Collections.list(e);
        ArrayList<Item> it = new ArrayList();

        for (String i : id) {
            Item item = new Item();
            it.add(item.fetchId(Integer.parseInt(i)));
        }
        return it;
    }
    
    
    public static Double getItensSum(HttpServletRequest request) throws SQLException{
        Double sum = (double)0;
        for (Item i : getItensList(request)) {
           sum += i.getValor();
        }
        return sum;
    } 
    
    public static String format(double x) {  
    DecimalFormat df = new DecimalFormat("#0.00");  
    return df.format(x);
}
}
