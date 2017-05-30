/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DatabaseAccess;
import model.OrderProducts;
import model.Orders;
import model.Processes;
import model.Stocks;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Adam
 */
public class ProcessingScheduleController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        
        // get unfinished orders
        List<Orders> orders = DatabaseAccess.getOrdersUnfinished();
        // get result stocks
        List<Stocks> resultStocks = DatabaseAccess.getResultStocks();
        // get current factory time
        Date factoryDatetime = DatabaseAccess.getDatetime();
        
        // loop through order to check orders
        for(int c = 0; c < orders.size(); c++){
            Object[] contOrderProducts = orders.get(c).getOrderProductses().toArray();
            OrderProducts[] orderProducts = new OrderProducts[contOrderProducts.length];
            for(int c1 = 0; c1 < contOrderProducts.length; c1++){
                orderProducts[c1] = (OrderProducts) contOrderProducts[c1];
            }
            
            // loop through orderProducts inside order
            for(int c1 = 0; c1 < orderProducts.length; c1++){
                // search through resultStock
                for(int c2 = 0; c2 < resultStocks.size(); c2++){
                    if(resultStocks.get(c2).getId() == orderProducts[c1].getId().getStockId()){
                        // if stock enough or more
                        if(resultStocks.get(c2).getAmount() >= orderProducts[c1].getAmount()){
                            resultStocks.get(c2).setAmount(resultStocks.get(c2).getAmount() - orderProducts[c1].getAmount());
                            orderProducts[c1].setAmount(0);
                        }
                        // else if stock is not empty
                        else if(resultStocks.get(c2).getAmount() > 0){
                            orderProducts[c1].setAmount(orderProducts[c1].getAmount() - resultStocks.get(c2).getAmount());
                            resultStocks.get(c2).setAmount(0);
                        }
                        break;
                    }
                }
            }
        }
        
        List<Integer> finishHours = new ArrayList();
        // loop orders to count time for each order
        for(Orders order : orders){
            Set<OrderProducts> orderProducts = order.getOrderProductses();
            int processingOrder = order.getProcessingOrder();
            List<Integer> times = new ArrayList();
            
            for(int c = 0; c < orderProducts.size(); c++){
                times.add(0);
            }
            
            // check and compare time of each products
            int timeCounter = 0;
            for(OrderProducts orderProduct : orderProducts){
                // get process information for this orderProduct element
                Processes process = DatabaseAccess.getProcessFromResult(orderProduct.getId().getStockId()).get(0);
                // check time for the same product on every order
                for(int c = 0; c <= processingOrder; c++){
                    // find the object for this loop
                    for(Orders order1 : orders){
                        if(order1.getProcessingOrder() == c){
                            Set<OrderProducts> orderProducts1 = order1.getOrderProductses();
                            for(OrderProducts orderProduct1 : orderProducts1){
                                // if orders has the same item
                                if(orderProduct1.getId().getStockId() == orderProduct.getId().getStockId()){
                                    // amount needed / amount per hour = hour for process
                                    int contTime = times.get(timeCounter) + (orderProduct1.getAmount() / process.getResultAmount());
                                    times.set(timeCounter, contTime);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                timeCounter++;
            }
            // get time for this order
            int neededHour = 0;
            for(Integer time : times){
                if(time > neededHour){
                    neededHour = time;
                }
            }

            // get time for this order
            finishHours.add(neededHour);
        }
        // initialize orders with database values
        orders = DatabaseAccess.getOrdersUnfinished();
        // sort according to finishing time
        for(int c = 0; c < orders.size() - 1; c++){
            for(int c1 = 0; c1 < orders.size() - 1; c1++){
                if(finishHours.get(c1 + 1) < finishHours.get(c1)){
                    int contHour = finishHours.get(c1 + 1);
                    finishHours.set(c1+1, finishHours.get(c1));
                    finishHours.set(c1, contHour);

                    Orders contOrder = orders.get(c1 + 1);
                    orders.set(c1+1, orders.get(c1));
                    orders.set(c1, contOrder);
                }
            }
        }
        
        mv = new ModelAndView("manager/processing_schedule");
        mv.addObject("orders", orders);
        mv.addObject("finishHours", finishHours);
        
        return mv;
    }
}
