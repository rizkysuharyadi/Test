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
import model.Stocks;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Claudia
 */
public class NewProcessController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv;
        Processes process = new Processes();
        Stocks stocks = new Stocks();
        ProcessMaterials processMaterials = new ProcessMaterials();
        ProcessMaterialsId processMaterialsId = new ProcessMaterialsId();
        
        // if missing variable
        if (!hsr.getParameterMap().containsKey("name")) {
            mv = new ModelAndView("manager/new_process");
        }
        // if name already exists
        else if(!DatabaseAccess.getProcessesTable(hsr.getParameter("name")).isEmpty()){
            mv = new ModelAndView("manager/new_process");
            mv.addObject("message", "Name exists!");
        }
        else{
            // get input parameters
            String name = hsr.getParameter("name");
            int resultId = Integer.parseInt(hsr.getParameter("resultId"));
            int resultAmount = Integer.parseInt(hsr.getParameter("resultAmount"));
            float errorChance = Float.parseFloat(hsr.getParameter("errorChance"));
            
            // set variables on process
            process.setName(name);
            stocks.setId(resultId);
            process.setStocks(stocks);
            process.setResultAmount(resultAmount);
            process.setErrorChance(errorChance);
            
            // save process to database
            DatabaseAccess.addProcess(process);
            
            // get input parameters
            int materialId = Integer.parseInt(hsr.getParameter("materialId"));
            int materialAmount = Integer.parseInt(hsr.getParameter("materialAmount"));

            // set variables on process materials id
            process = DatabaseAccess.getProcessesTable(name).get(0);
            processMaterialsId.setProcessId(process.getId());
            processMaterialsId.setProcessMaterialId(materialId);
            
            // set variables on process materials
            processMaterials.setId(processMaterialsId);
            stocks.setId(materialId);
            processMaterials.setStocks(stocks);
            processMaterials.setAmount(materialAmount);
            
            // save process materials to database
            DatabaseAccess.addProcessMaterials(processMaterials);
            
            // log
            List<Processes> processes;
            processes = DatabaseAccess.getLastProcess();
            
            Logs log = new Logs();
            
            Accounts account = new Accounts();
            account.setId(1);
            
            String action = "Added process no " + processes.get(0).getId() + ": " + processes.get(0).getName();
            
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            
            log.setAccounts(account);
            log.setAction(action);
            log.setTime(timestamp);
            
            // save log to database
            DatabaseAccess.saveLog(log);
            
            mv = new ModelAndView("redirect:manage_processes.htm");
            mv.addObject("message", "Process added!");
        }
        return mv;
    }
}
