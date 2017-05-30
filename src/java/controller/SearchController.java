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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Claudia
 */
public class SearchController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        List<Accounts> accounts = null;
        
        // if button not pressed
        if(!hsr.getParameterMap().containsKey("search")){

            String search = hsr.getParameter("search");
            
            mv = new ModelAndView("administrator/manage_users");
            
            accounts = DatabaseAccess.getUsersTable();
            mv.addObject("accounts", accounts);
        }
        else{ // if button pressed
            String search = hsr.getParameter("search");
            accounts = DatabaseAccess.getSearchedUsers("%"+search+"%");
            mv = new ModelAndView("administrator/manage_users");
            
            mv.addObject("accounts", accounts);
            
        }
        
        return mv;
    }
    
}
