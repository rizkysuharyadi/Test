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
 * @author Adam
 */
public class NewOrderController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv;
        Orders order = new Orders();
        
        // if missing variable
        if (!hsr.getParameterMap().containsKey("targetDate") || !hsr.getParameterMap().containsKey("requester") || !hsr.getParameterMap().containsKey("finished")) {
            mv = new ModelAndView("director/new_order");
        }
        else{
            Date targetDate = new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(hsr.getParameter("targetDate")).getTime());
            String requester = hsr.getParameter("requester");
            boolean finished = Boolean.valueOf(hsr.getParameter("finished"));
            
            order.setTargetDate(targetDate);
            order.setRequester(requester);
            order.setFinished(finished);
            
            DatabaseAccess.addOrder(order);
            
            // log
            List<Orders> orders;
            orders = DatabaseAccess.getLastOrder();
            
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Added order no. " + orders.get(0).getId() + " for " + orders.get(0).getRequester();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            String message = "Order added!";
            mv = new ModelAndView("redirect:manage_orders.htm?message=" + message);
        }
        return mv;
    }
}
