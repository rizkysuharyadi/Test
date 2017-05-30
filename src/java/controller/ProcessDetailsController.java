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
import model.ProcessStages;
import model.Processes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Adam
 */
public class ProcessDetailsController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("manager/process_details");
        
        // if no ID
        if(!hsr.getParameterMap().containsKey("id")){
            mv = new ModelAndView("redirect:factory_status.htm");
        }
        // if user renames process
        else if(hsr.getParameterMap().containsKey("rename")){
            int id = Integer.parseInt(hsr.getParameter("id"));
            String rename = hsr.getParameter("rename");
            
            // edit process
            Processes process = DatabaseAccess.getProcess(id).get(0);
            Processes renameProcess = new Processes();
            renameProcess.setId(process.getId());
            renameProcess.setName(rename);
            renameProcess.setErrorChance(process.getErrorChance());
            renameProcess.setProcessStageses(process.getProcessStageses());
            renameProcess.setStocks(process.getStocks());
            renameProcess.setResultAmount(process.getResultAmount());
            
            DatabaseAccess.editProcess(renameProcess);
            
            // add process to mv
            Processes newProcess = DatabaseAccess.getProcess(id).get(0);
            mv.addObject("process", newProcess);

            // get process stages
            List<ProcessStages> processStages = DatabaseAccess.getProcessStages(id);
            mv.addObject("processStages", processStages);
        }
        else{
            // get selected process
            int id = Integer.parseInt(hsr.getParameter("id"));
            Processes process = DatabaseAccess.getProcess(id).get(0);

            // add process to mv
            mv.addObject("process", process);

            // get process stages
            List<ProcessStages> processStages = DatabaseAccess.getProcessStages(id);
            mv.addObject("processStages", processStages);
        }
        
        return mv;
    }
    
}
