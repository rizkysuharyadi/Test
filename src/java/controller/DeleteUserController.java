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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Adam
 */
public class DeleteUserController implements Controller{
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        if(!hsr.getParameterMap().containsKey("confirm")){
            int id = Integer.parseInt(hsr.getParameter("id"));
            
            mv = new ModelAndView("administrator/delete_user");
            mv.addObject("id", id);
            
            Accounts account = DatabaseAccess.getUser(id).get(0);
            mv.addObject("account", account);
        }
        else{
            List<Accounts> accounts;
        
            accounts = DatabaseAccess.getUser(Integer.parseInt(hsr.getParameter("id")));
            
            // log
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Deleted user " + accounts.get(0).getName();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            // delete user from database
            DatabaseAccess.deleteUser(accounts.get(0));

            mv = new ModelAndView("redirect:manage_users.htm");
        }
        return mv;
    }
    
}
