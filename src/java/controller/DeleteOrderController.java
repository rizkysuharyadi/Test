/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class DeleteOrderController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        if(!hsr.getParameterMap().containsKey("confirm")){
            int id = Integer.parseInt(hsr.getParameter("id"));
            
            mv = new ModelAndView("director/delete_order");
            mv.addObject("id", id);
            
            Orders order = DatabaseAccess.getOrder(id).get(0);
            mv.addObject("order", order);
        }
        else{
            List<Orders> orders;
        
            orders = DatabaseAccess.getOrder(Integer.parseInt(hsr.getParameter("id")));

            // log
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Deleted order " + orders.get(0).getRequester();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            // delete order from database
            DatabaseAccess.deleteOrder(orders.get(0));

            mv = new ModelAndView("redirect:manage_orders.htm");
        }
        return mv;
    }
}
