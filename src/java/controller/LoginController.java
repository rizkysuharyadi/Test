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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Adam
 */
public class LoginController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String username;
        String password;
        String type;
        
        String message;
        
        // if missing username or password
        if (!hsr.getParameterMap().containsKey("username") || !hsr.getParameterMap().containsKey("password")) {
            mv = new ModelAndView("login");
        }
        else{
            username = hsr.getParameter("username");
            password = hsr.getParameter("password");
            
            List<Accounts> account = DatabaseAccess.getUser(username, password);
                
            // if query empty
            if(account.isEmpty())
            {
                mv = new ModelAndView("login");

                message = "Login failed!";
                mv.addObject("message", message);
            }
            // if query found
            else{
                // create cookie
                Cookie cookieId = new Cookie("id", Integer.toString(account.get(0).getId()));
                Cookie cookie = new Cookie("name", account.get(0).getName());
                Cookie cookie1 = new Cookie("username", account.get(0).getUsername());
                Cookie cookie2 = new Cookie("type", account.get(0).getType());
                cookieId.setMaxAge(60*30);
		cookie.setMaxAge(60*30);
		cookie1.setMaxAge(60*30);
		cookie2.setMaxAge(60*30);
                hsr1.addCookie(cookieId);
		hsr1.addCookie(cookie);
		hsr1.addCookie(cookie1);
		hsr1.addCookie(cookie2);
                
                String loginid = "";
                // get a cookie
                Cookie[] cookies = hsr.getCookies();
                for (int i = 0; i < cookies.length; i++) {
                   Cookie cd = cookies[i];
                   if (cd.getName().equals("type")) {
                    loginid = cd.getValue();
                   }
                }

                switch(loginid){
                    case "Administrator":
                        mv = new ModelAndView("redirect:manage_users.htm");
                        break;
                    case "Director":
                        mv = new ModelAndView("redirect:manage_orders.htm");
                        break;
                    case "Manager":
                        mv = new ModelAndView("redirect:factory_status.htm");
                        break;
                }
            }
        }
        
        return mv;
    }
    
}
