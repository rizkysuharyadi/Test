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
import model.Processes;
import model.Stocks;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Adam
 */
public class NewStockController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv;
        Stocks stock = new Stocks();
        
        // if missing variable
        if (!hsr.getParameterMap().containsKey("name") || !hsr.getParameterMap().containsKey("type") || !hsr.getParameterMap().containsKey("amount")) {
            mv = new ModelAndView("manager/new_stock");
        }
        // if name already exists
        else if(!DatabaseAccess.getStocksTable(hsr.getParameter("name")).isEmpty()){
            mv = new ModelAndView("manager/new_stock");
            mv.addObject("message", "Name exists!");
        }
        else{
            String name = hsr.getParameter("name");
            String type = hsr.getParameter("type");
            int amount = Integer.parseInt(hsr.getParameter("amount"));
            
            stock.setName(name);
            stock.setType(type);
            stock.setAmount(amount);
            
            DatabaseAccess.addStock(stock);
            
            // log
            List<Stocks> stocks;
            stocks = DatabaseAccess.getLastStock();
            
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Added stock no " + stocks.get(0).getId() + ": " + stocks.get(0).getName();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            mv = new ModelAndView("redirect:manage_stocks.htm");
            mv.addObject("message", "Stock added!");
        }
        return mv;
    }
}
