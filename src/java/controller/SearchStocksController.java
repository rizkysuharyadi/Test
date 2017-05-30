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
 * @author Claudia
 */
public class SearchStocksController implements Controller {
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        List<Stocks> stocks = null;
        
        // if button not pressed
        if(!hsr.getParameterMap().containsKey("search")){

            String search = hsr.getParameter("search");
            
            mv = new ModelAndView("manager/manage_stocks");
            
            stocks = DatabaseAccess.getStocksTable();
            mv.addObject("stocks", stocks);
        }
        else{ // if button pressed
            String search = hsr.getParameter("search");
            stocks = DatabaseAccess.getSearchedStocks("%"+search+"%");
            mv = new ModelAndView("manager/manage_stocks");
            
            mv.addObject("stocks", stocks);
            
        }
        
        return mv;
    }
}
