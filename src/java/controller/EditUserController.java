/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.Cookie;
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
public class EditUserController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        
        if (!hsr.getParameterMap().containsKey("name") || !hsr.getParameterMap().containsKey("username") || !hsr.getParameterMap().containsKey("password") || !hsr.getParameterMap().containsKey("type")) {
            mv = new ModelAndView("administrator/edit_user");
            mv.addObject("message", "Please fill the form completely.");
        }
        // if passwords do not match
        else if(!hsr.getParameter("password").equals(hsr.getParameter("confirmPassword"))){
            mv = new ModelAndView("administrator/edit_user");
            mv.addObject("message", "Passwords do not match");
        }
        // if username already exists
        else if(!DatabaseAccess.checkSimilarUser(Integer.parseInt(hsr.getParameter("id")), hsr.getParameter("username")).isEmpty()){
            mv = new ModelAndView("administrator/edit_user");
            mv.addObject("message", "Username exists!");
        }
        else{
            int id = Integer.parseInt(hsr.getParameter("id"));
            String name = hsr.getParameter("name");
            String username = hsr.getParameter("username");
            String password = hsr.getParameter("password");
            String type = hsr.getParameter("type");
            
            Accounts account = new Accounts();
            account.setId(id);
            account.setName(name);
            account.setUsername(username);
            account.setPassword(password);
            account.setType(type);
            
            DatabaseAccess.editUser(account);
            
            // log
            List<Accounts> accounts;
            accounts = DatabaseAccess.getUser(id);
            
            Logs log = new Logs();
            int cookieid = 0;
            
            Cookie[] cookies = hsr.getCookies();
                for (int i = 0; i < cookies.length; i++) {
                   Cookie cd = cookies[i];
                   if (cd.getName().equals("id")) {
                    cookieid = Integer.parseInt(cd.getValue());
                   }
                }
            
            Accounts accountForLog = DatabaseAccess.getUser(cookieid).get(0);
            
            String action = "Edited account no. " + accounts.get(0).getId() + ": " + accounts.get(0).getName() + " (" + accounts.get(0).getUsername() + ")";
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(accountForLog);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            mv = new ModelAndView("redirect:manage_users.htm");
            mv.addObject("message", "User edited!");
        }
        
        Accounts account = DatabaseAccess.getUser(Integer.parseInt(hsr.getParameter("id"))).get(0);
        mv.addObject("account", account);
        
        return mv;
    }
    
}
