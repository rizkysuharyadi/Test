package model;
// Generated May 17, 2017 8:45:27 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Stocks generated by hbm2java
 */
public class Stocks  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String type;
     private int amount;
     private Set processeses = new HashSet(0);
     private Set orderProductses = new HashSet(0);
     private Set processMaterialses = new HashSet(0);

    public Stocks() {
    }

	
    public Stocks(String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }
    public Stocks(String name, String type, int amount, Set processeses, Set orderProductses, Set processMaterialses) {
       this.name = name;
       this.type = type;
       this.amount = amount;
       this.processeses = processeses;
       this.orderProductses = orderProductses;
       this.processMaterialses = processMaterialses;
    }

    public Stocks(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public int getAmount() {
        return this.amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Set getProcesseses() {
        return this.processeses;
    }
    
    public void setProcesseses(Set processeses) {
        this.processeses = processeses;
    }
    public Set getOrderProductses() {
        return this.orderProductses;
    }
    
    public void setOrderProductses(Set orderProductses) {
        this.orderProductses = orderProductses;
    }
    public Set getProcessMaterialses() {
        return this.processMaterialses;
    }
    
    public void setProcessMaterialses(Set processMaterialses) {
        this.processMaterialses = processMaterialses;
    }




}


