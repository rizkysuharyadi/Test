/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DatabaseAccess;
import model.Orders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Claudia
 */
public class SearchOrdersController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        List<Orders> orders = null;
        
        // if button not pressed
        if(!hsr.getParameterMap().containsKey("search")){

            String search = hsr.getParameter("search");
            
            mv = new ModelAndView("director/manage_orders");
            
            orders = DatabaseAccess.getOrdersTable();
            mv.addObject("orders", orders);
        }
        else{ // if button pressed
            String search = hsr.getParameter("search");
            orders = DatabaseAccess.getSearchedOrders("%"+search+"%");
            mv = new ModelAndView("director/manage_orders");
            
            mv.addObject("orders", orders);
            
        }
        
        return mv;
    }
}
