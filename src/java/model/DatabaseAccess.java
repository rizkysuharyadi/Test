/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Adam
 */
public class DatabaseAccess {
    
    // GET ALL USERS
    public static List<Accounts> getUsersTable(){
        List<Accounts> accounts = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Accounts ORDER BY name";
            Query query = session.createQuery(sql);
            
            accounts = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return accounts;
    }
    
    // GET ALL USERS WITH SPECIFIED USERNAME
    public static List<Accounts> getUsersTable(String username){
        List<Accounts> accounts = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Accounts WHERE username=:username";
            Query query = session.createQuery(sql);
            query.setParameter("username", username);
            
            accounts = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return accounts;
    }
    
    // GET ALL USERS WITH SPECIFIED *USERNAME AND PASSWORD*
    public static List<Accounts> getUser(String username, String password){
        List<Accounts> account = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Accounts WHERE username=:username AND password=:password";
            
            Query query = session.createQuery(sql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            
            account = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return account;
    }
    
    // GET USER WITH CORRESPONDING ID
    public static List<Accounts> getUser(int id){
        List<Accounts> account = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Accounts WHERE id=:id";
            
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            
            account = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return account;
    }
    
    // CHECK TO SEE NO USER HAS THE SAME ID
    public static List<Accounts> checkSimilarUser(int id, String username){
        List<Accounts> account = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Accounts WHERE id!=:id AND username=:username";
            
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            query.setParameter("username", username);
            
            account = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return account;
    }
    
    // Get last inserted user account
    public static List<Accounts> getLastUser(){
        List<Accounts> accounts = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Accounts ORDER BY id DESC";
            Query query = session.createQuery(sql);
            
            accounts = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        
        return accounts;
    }
    
    // ADD USER
    public static void addUser(Accounts account){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            // insert to database
            session.save(account);
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            
        }
    }
    
    // EDIT USER
    public static void editUser(Accounts account){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // modify account in database
            session.update(account);

            // commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    // DELETE USER
    public static void deleteUser(Accounts account){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // delete account in database
            session.delete(account);

            // commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    public static List<Processes> getProcessesTable(){
        List<Processes> processes = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Processes ORDER BY id";
            Query query = session.createQuery(sql);
            
            processes = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return processes;
    }
    
    public static List<Processes> getProcessesTable(String name){
        List<Processes> processes = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Processes WHERE name=:name";
            Query query = session.createQuery(sql);
            query.setParameter("name", name);
            
            processes = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return processes;
    }
    
    public static List<Processes> getLastProcess(){
        List<Processes> processes = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Processes ORDER BY id DESC";
            Query query = session.createQuery(sql);
            
            processes = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        
        return processes;
    }
    
    // ADD PROCESS MATERIALS
    public static void addProcessMaterials(ProcessMaterials processMaterials){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Save stock in database
            session.save(processMaterials);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    // ADD PROCESSES
    public static void addProcess(Processes process){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Save stock in database
            session.save(process);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    // DELETE PROCESSES
    public static void deleteProcess(Processes process){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Save the employee in database
            session.delete(process);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    public static List<Processes> getProcess(int id){
        List<Processes> process = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Processes WHERE id=:id";
            
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            
            process = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            
        }
        
        return process;
    }
    
    public static List<Processes> getProcessFromResult(int resultId){
        List<Processes> process = null;
        
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Processes WHERE result_id=:resultId";
            
            Query query = session.createQuery(sql);
            query.setParameter("resultId", resultId);
            
            process = query.list();
            
            session.getTransaction().commit();
            session.close();
        
        return process;
    }
    
    // EDIT PROCESS
    public static void editProcess(Processes process){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.update(process);

            // commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    public static List<ProcessStages> getProcessStages(int processId){
        List<ProcessStages> processStages = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM ProcessStages WHERE id.processId=:processId ORDER BY id.stageIndex";
            
            Query query = session.createQuery(sql);
            query.setParameter("processId", processId);
            
            processStages = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return processStages;
    }
    
    public static boolean isProcessUsed(int processId){
        boolean processUsed = false;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // get selected process's result
            String sql = "SELECT DISTINCT stocks FROM Processes p WHERE p.id=:processId";
            Query query = session.createQuery(sql);
            query.setParameter("processId", processId);
            List<Stocks> resultStock = query.list();

            // get orderId from OrderProducts using resultId
            sql = "FROM OrderProducts WHERE stock_id=:resultId";
            query = session.createQuery(sql);
            query.setParameter("resultId", resultStock.get(0).getId());
            List<OrderProducts> orderProducts = query.list();

            //get unfinished orders from list
            for(int c = 0; c < orderProducts.size(); c++){
                sql = "FROM Orders WHERE id=:id AND finished=false";
                query = session.createQuery(sql);
                query.setParameter("id", orderProducts.get(c).getId().getOrderId());

                // if there is order
                if(!query.list().isEmpty()){
                    processUsed = true;
                    break;
                }
            }

            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        
        return processUsed;
    }
    
    public static boolean isProcessAble(int processId){
        boolean processUsed = true;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // get selected process's materials
            String sql = "FROM ProcessMaterials WHERE id.processId=:processId";
            Query query = session.createQuery(sql);
            query.setParameter("processId", processId);
            List<ProcessMaterials> processMaterials = query.list();
            
            for(int c = 0; c < processMaterials.size(); c++){
                sql = "FROM Stocks WHERE id=:processMaterialId AND amount>=:amount";
                query = session.createQuery(sql);
                query.setParameter("processMaterialId", processMaterials.get(c).getStocks().getId());
                query.setParameter("amount", processMaterials.get(c).getAmount());
                if(query.list().isEmpty()){
                    processUsed = false;
                    break;
                }
            }

            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        
        return processUsed;
    }
    
    public static List<ProcessMaterialsId> getProcessMaterialsId(int processId){
        List<ProcessMaterialsId> materials = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM ProcessMaterials WHERE id.processId=:processId";
            
            Query query = session.createQuery(sql);
            query.setParameter("processId", processId);
            
            materials = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return materials;
    }
    
    public static List<ProcessMaterials> getProcessMaterials(int processId){
        List<ProcessMaterials> materials = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM ProcessMaterials WHERE id.processId=:processId";
            
            Query query = session.createQuery(sql);
            query.setParameter("processId", processId);
            
            materials = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return materials;
    }
    
    public static List<Stocks> getMaterialStocks(){
        List<Stocks> materials = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Stocks WHERE type='Material' ORDER BY id";
            Query query = session.createQuery(sql);
            
            materials = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return materials;
    }
    
    public static List<Stocks> getResultStocks(){
        List<Stocks> results = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Stocks WHERE type='Result' ORDER BY id";
            Query query = session.createQuery(sql);
            
            results = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return results;
    }
    
    public static List<Stocks> getStock(int id){
        List<Stocks> stock = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Stocks WHERE id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            
            stock = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        
        return stock;
    }
    
    public static List<Stocks> getStocksTable(){
        List<Stocks> stocks = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Stocks";
            Query query = session.createQuery(sql);
            stocks = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return stocks;
    }
    
    public static List<Stocks> getStocksTable(String name){
        List<Stocks> stocks = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Stocks WHERE name=:name";
            Query query = session.createQuery(sql);
            query.setParameter("name", name);
            
            stocks = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return stocks;
    }
    
    public static List<Stocks> getLastStock(){
        List<Stocks> stocks = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Stocks ORDER BY id DESC";
            Query query = session.createQuery(sql);
            
            stocks = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        
        return stocks;
    }
    
    // ADD STOCKS
    public static void addStock(Stocks stock){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Save stock in database
            session.save(stock);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    
    // DELETE STOCKS
    public static void deleteStock(Stocks stock){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Save the employee in database
            session.delete(stock);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    // EDIT STOCKS
    public static void editStock(Stocks stock){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.update(stock);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    public static List<Stocks> checkSimilarStock(int id, String name){
        List<Stocks> stock = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Stocks WHERE id!=:id AND name=:name";
            
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            query.setParameter("name", name);
            
            stock = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return stock;
    }
    
    public static List<Orders> getOrdersTable(){
        List<Orders> orders = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Orders ORDER BY processingOrder";
            Query query = session.createQuery(sql);
            
            orders = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        
        return orders;
    }
    
    public static List<Orders> getLastOrder(){
        List<Orders> orders = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Orders ORDER BY id DESC";
            Query query = session.createQuery(sql);
            
            orders = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        
        return orders;
    }
    
    public static List<Orders> getOrdersUnfinished(){
        List<Orders> orders = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Orders WHERE processingOrder > -1 ORDER BY processingOrder";
            Query query = session.createQuery(sql);
            
            orders = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return orders;
    }
    
    public static List<Orders> getOrder(int id){
        List<Orders> order = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Orders WHERE id=:id";
            
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            
            order = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return order;
    }
    
    public static List<Orders> checkSimilarOrder(int id, String requester){
        List<Orders> orders = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Orders WHERE id!=:id and requester=:requester";
            
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            query.setParameter("requester", requester);
            
            orders = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return orders;
    }
    
    public static void addOrder(Orders order){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            // insert to db
            session.save(order);
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    // EDIT ORDERS
    public static void editOrder(Orders order){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.update(order);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteOrder(Orders order){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Save the employee in database
            session.delete(order);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
    
    // GET DATE FROM FACTORY STATUS
    public static Date getDatetime(){
        Date datetime = null;
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM FactoryStatus";
            Query query = session.createQuery(sql);
            
            List<FactoryStatus> factoryStatus = query.list();
            datetime = factoryStatus.get(0).getNowTime();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            
        }
        
        return datetime;
    }
    
    // SEARCH USERS

    public static List<Accounts> getSearchedUsers(String search){
        List<Accounts> accounts = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Accounts WHERE name LIKE :search OR username LIKE :search OR type LIKE :search";
            Query query = session.createQuery(sql);
            query.setParameter("search", search);
            
            accounts = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return accounts;
    }

    
    // SEARCH STOCKS
    public static List<Stocks> getSearchedStocks(String search){
        List<Stocks> stocks = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Stocks WHERE name LIKE :search OR type LIKE :search";
            Query query = session.createQuery(sql);
            query.setParameter("search", search);
            
            stocks = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return stocks;
    }
    
    // SEARCH ORDERS
    public static List<Orders> getSearchedOrders(String search){
        List<Orders> orders = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Orders WHERE requester LIKE :search";
            Query query = session.createQuery(sql);
            query.setParameter("search", search);
            
            orders = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return orders;
    }

    // SEARCH PROCESSES
    public static List<Processes> getSearchedProcesses(String search){
        List<Processes> processes = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Processes WHERE name LIKE :search";
            Query query = session.createQuery(sql);
            query.setParameter("search", search);
            
            processes = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return processes;
    }
    
    // SAVE LOG
    public static void saveLog(Logs log){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            // insert log into database
            session.save(log);
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            
        }
    }
    
    // GET ALL LOGS
    public static List<Logs> getLogsTable(){
        List<Logs> logs = null;
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String sql = "FROM Logs ORDER BY id";
            Query query = session.createQuery(sql);
            
            logs = query.list();
            
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return logs;
    }
    
    // DELETE PROCESSES
    public static void deleteProcessMaterials(ProcessMaterials processMaterials){
        
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Save the employee in database
            session.delete(processMaterials);

            //Commit the transaction
            session.getTransaction().commit();
            session.close();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
    }
}

