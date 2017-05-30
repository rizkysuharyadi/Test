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
import model.ProcessMaterials;
import model.ProcessMaterialsId;
import model.Processes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Claudia
 */
public class DeleteProcessController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        
        if(!hsr.getParameterMap().containsKey("confirm")){
            int id = Integer.parseInt(hsr.getParameter("id"));
            
            mv = new ModelAndView("manager/delete_process");
            mv.addObject("id", id);
            
            Processes process = DatabaseAccess.getProcess(id).get(0);
            mv.addObject("process", process);
        }
        else{
            List<Processes> processes;
        
            processes = DatabaseAccess.getProcess(Integer.parseInt(hsr.getParameter("id")));
            
            List<ProcessMaterials> processMaterials;
            processMaterials = DatabaseAccess.getProcessMaterials(Integer.parseInt(hsr.getParameter("id")));
            // log
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Deleted process and its materials: " + processes.get(0).getName();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            // delete process materials from database
            DatabaseAccess.deleteProcessMaterials(processMaterials.get(0));
            
            // delete process from database
            DatabaseAccess.deleteProcess(processes.get(0));
            
            mv = new ModelAndView("redirect:manage_processes.htm");
        }
        return mv;
    }
}
