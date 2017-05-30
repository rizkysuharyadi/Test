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
import model.Stocks;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Adam
 */
public class EditStockController implements Controller {
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        
        if (!hsr.getParameterMap().containsKey("name") || !hsr.getParameterMap().containsKey("type") || !hsr.getParameterMap().containsKey("amount")) {
            mv = new ModelAndView("manager/edit_stock");
            mv.addObject("message", "Please fill the form completely.");
        }
        // if stock already exists
        else if(!DatabaseAccess.checkSimilarStock(Integer.parseInt(hsr.getParameter("id")), hsr.getParameter("name")).isEmpty()){
            mv = new ModelAndView("manager/edit_user");
            mv.addObject("message", "Name exists!");
        }
        else{
            int id = Integer.parseInt(hsr.getParameter("id"));
            String name = hsr.getParameter("name");
            String type = hsr.getParameter("type");
            int amount = Integer.parseInt(hsr.getParameter("amount"));
            
            Stocks stock = new Stocks();
            stock.setId(id);
            stock.setName(name);
            stock.setType(type);
            stock.setAmount(amount);
            
            DatabaseAccess.editStock(stock);
            
            // log
            List<Stocks> stocks;
            stocks = DatabaseAccess.getStock(id);
            
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Edited stock no " + stocks.get(0).getId() + ": " + stocks.get(0).getName();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            mv = new ModelAndView("redirect:manage_stocks.htm");
            mv.addObject("message", "Stock edited!");
        }
        
        Stocks stock = DatabaseAccess.getStock(Integer.parseInt(hsr.getParameter("id"))).get(0);
        mv.addObject("stock", stock);
        
        return mv;
    }
    
}
