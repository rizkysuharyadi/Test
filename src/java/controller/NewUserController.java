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
public class NewUserController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv;
        Accounts account = new Accounts();
        
        // if missing variable
        if (!hsr.getParameterMap().containsKey("username") || !hsr.getParameterMap().containsKey("password") || !hsr.getParameterMap().containsKey("name") || !hsr.getParameterMap().containsKey("confirmPassword") || !hsr.getParameterMap().containsKey("type")) {
            mv = new ModelAndView("administrator/new_user");
        }
        // if passwords do not match
        else if(!hsr.getParameter("password").equals(hsr.getParameter("confirmPassword"))){
            mv = new ModelAndView("administrator/new_user");
            mv.addObject("message", "Passwords do not match");
        }
        // if username already exists
        else if(!DatabaseAccess.getUsersTable(hsr.getParameter("username")).isEmpty()){
            mv = new ModelAndView("administrator/new_user");
            mv.addObject("message", "Username exists!");
        }
        else{
            String name = hsr.getParameter("name");
            String username = hsr.getParameter("username");
            String password = hsr.getParameter("password");
            String type = hsr.getParameter("type");
            
            account.setName(name);
            account.setUsername(username);
            account.setPassword(password);
            account.setType(type);
            
            DatabaseAccess.addUser(account);
            
            // log
            List<Accounts> accounts;
            accounts = DatabaseAccess.getLastUser();
            
            Logs log = new Logs();
            
            Accounts accountForLog = new Accounts();
            accountForLog.setId(1);
            
            String action = "Added account no. " + accounts.get(0).getId() + ": " + accounts.get(0).getName() + " (" + accounts.get(0).getUsername() + ")";
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(accountForLog);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            mv = new ModelAndView("redirect:manage_users.htm");
            mv.addObject("message", "User added!");
        }
        return mv;
    }
    
}
