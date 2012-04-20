/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.dao;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhon
 */
public class Conexion {
    private static Conexion INSTANCE = null;
    public DB db;
     private Conexion() {
     Mongo m = null;
        try {
            m = new Mongo( "localhost" , 27017 );
            db = m.getDB( "test" );
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MongoException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
 
   private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Conexion();
        }
    }
 
    public static Conexion getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
}
