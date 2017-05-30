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
public class DeleteStockController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        if(!hsr.getParameterMap().containsKey("confirm")){
            int id = Integer.parseInt(hsr.getParameter("id"));
            
            mv = new ModelAndView("manager/delete_stock");
            mv.addObject("id", id);
            
            Stocks stock = DatabaseAccess.getStock(id).get(0);
            mv.addObject("stock", stock);
        }
        else{
            List<Stocks> stocks;
        
            stocks = DatabaseAccess.getStock(Integer.parseInt(hsr.getParameter("id")));
            
            // log
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Deleted stock " + stocks.get(0).getName();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            DatabaseAccess.deleteStock(stocks.get(0));

            mv = new ModelAndView("redirect:manage_stocks.htm");
        }
        return mv;
    }
}
