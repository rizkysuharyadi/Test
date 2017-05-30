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
import model.Stocks;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Adam
 */
public class ManageStocksController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("manager/manage_stocks");
        
        List<Stocks> materials = DatabaseAccess.getMaterialStocks();
        mv.addObject("materials", materials);
        
        List<Stocks> results = DatabaseAccess.getResultStocks();
        mv.addObject("results", results);
        
        List<Stocks> stocks = DatabaseAccess.getStocksTable();
        mv.addObject("stocks", stocks);
        
        return mv;
    }
    
}
