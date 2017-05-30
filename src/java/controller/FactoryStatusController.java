/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DatabaseAccess;
import model.ProcessMaterials;
import model.Processes;
import model.Stocks;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Adam
 */
public class FactoryStatusController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("manager/factory_status");
        
        // get processes
        List<Processes> processes = DatabaseAccess.getProcessesTable();
        mv.addObject("processes", processes);
        
        // if advance time
        if(hsr.getParameterMap().containsKey("advanceTime") && !hsr.getParameter("advanceTime").equals("")){
            int advanceTime = Integer.parseInt(hsr.getParameter("advanceTime"));
            for(int c2 = 0; c2 < advanceTime; c2++){
                // if process is used and able to be used
                for(int c = 0; c < processes.size(); c++){
                    processes = DatabaseAccess.getProcessesTable();
                    Processes process = processes.get(c);
                    if(DatabaseAccess.isProcessUsed(process.getId()) && DatabaseAccess.isProcessAble(process.getId())){
                        List<ProcessMaterials> materials = DatabaseAccess.getProcessMaterials(processes.get(c).getId());

                        // use materials
                        for(int c1 = 0; c1 < materials.size(); c1++){
                            Stocks stock = materials.get(c1).getStocks();
                            
                            int id = stock.getId();
                            String name = stock.getName();
                            String type = stock.getType();
                            int amount = stock.getAmount() - materials.get(c1).getAmount();

                            Stocks newMaterial = new Stocks();

                            newMaterial.setId(id);
                            newMaterial.setName(name);
                            newMaterial.setType(type);
                            newMaterial.setAmount(amount);

                            DatabaseAccess.editStock(newMaterial);
                        }
                        // add result
                        Stocks result = processes.get(c).getStocks();
                        Stocks newResult = new Stocks();

                        newResult.setId(result.getId());
                        newResult.setName(result.getName());
                        newResult.setType(result.getType());
                        newResult.setAmount(result.getAmount() + processes.get(c).getResultAmount());

                        DatabaseAccess.editStock(newResult);
                    }
                }
            }
        }
        
        // get processes after advancing time
        processes = DatabaseAccess.getProcessesTable();
        mv.addObject("processes", processes);
        
        // get process results
        List<String> processResults = new ArrayList();
        for(int c = 0; c < processes.size(); c++){
            processResults.add(processes.get(c).getStocks().getName() + " x" + processes.get(c).getResultAmount());
        }
        mv.addObject("processResults", processResults);
        
        // get process materials
        List<String> processMaterials = new ArrayList();
        for(int c = 0; c < processes.size(); c++){
            // get list of ProcessMaterials
            List<ProcessMaterials> cMaterials = DatabaseAccess.getProcessMaterials(processes.get(c).getId());
            // string for output container
            String cString = "";
            int c1 = 0;
            for(ProcessMaterials cProcessMaterials : cMaterials){
                cString = cString + cProcessMaterials.getStocks().getName() + " x" + Integer.toString(cProcessMaterials.getAmount());
                if(c1 < cMaterials.size() - 1){
                    cString += ", ";
                }
                c1++;
            }
            processMaterials.add(cString);
        }
        mv.addObject("processMaterials", processMaterials);
        
        // get factory's current date
        Date factoryDatetime = DatabaseAccess.getDatetime();
        mv.addObject("factoryDatetime", factoryDatetime);
        
        return mv;
    }
    
}
