/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.mongodb.DB;
import com.mongodb.Mongo;



public class MongoConnection {
    
    private static MongoConnection INSTANCE;
    private static Mongo m = null;
    private static DB db = null;
    
    public MongoConnection(){}
    
    public synchronized  MongoConnection getInstance(){
        if (INSTANCE == null) 
            INSTANCE = new MongoConnection();
        return INSTANCE;
    }
    
    public void connect(String username, String password, 
            String hostname, String database, int port) throws Exception{
        try{
            MongoConnection.m = new Mongo(hostname, port);
            MongoConnection.db = m.getDB(database);
        }
        catch(Exception e){
            System.out.print("No se pudo conectar a Mongo");}
           
        
    }
    
    public Mongo getConnection(){
        return this.m;
    }
    
    public DB getDatabase(){
        return this.db;
    }
}