/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Accounts;
import model.DatabaseAccess;
import model.Logs;
import model.Orders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Claudia
 */
public class EditOrderController implements Controller {
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        
        if (!hsr.getParameterMap().containsKey("targetDate") || !hsr.getParameterMap().containsKey("requester") || !hsr.getParameterMap().containsKey("finished")) {
            mv = new ModelAndView("director/edit_order");
            mv.addObject("message", "Please fill the form completely.");
        }
        // if username already exists
        else if(!DatabaseAccess.checkSimilarOrder(Integer.parseInt(hsr.getParameter("id")), hsr.getParameter("requester")).isEmpty()){
            mv = new ModelAndView("director/edit_order");
            mv.addObject("message", "Order exists!");
        }
        else{
            int id = Integer.parseInt(hsr.getParameter("id"));
            String requester = hsr.getParameter("requester");
            Date targetDate = new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(hsr.getParameter("targetDate")).getTime());
            boolean finished = Boolean.valueOf(hsr.getParameter("finished"));
            
            Orders order = new Orders();
            order.setId(id);
            order.setRequester(requester);
            order.setTargetDate(targetDate);
            order.setFinished(finished);
            
            DatabaseAccess.editOrder(order);
            
            // log
            List<Orders> orders;
            orders = DatabaseAccess.getOrder(id);
            
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Edited order no. " + orders.get(0).getId() + " for " + orders.get(0).getRequester();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            
            mv = new ModelAndView("redirect:manage_orders.htm");
            mv.addObject("message", "Order edited!");
        }
        
        Orders order = DatabaseAccess.getOrder(Integer.parseInt(hsr.getParameter("id"))).get(0);
        mv.addObject("order", order);
        
        return mv;
    }
}
