/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import org.certiweb.modelo.Productor;
import java.util.List;
import org.springframework.data.document.mongodb.query.Query;

import org.springframework.data.document.mongodb.query.Update;
import static org.springframework.data.document.mongodb.query.Criteria.where;

/**
 *
 * @author Jhon
 */
public class ProductorDAO {
     private static ProductorDAO INSTANCE = null;
    DBCollection coll;
     private ProductorDAO() {
        coll = Conexion.getInstance().db.getCollection("productor");
     }
 
   private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ProductorDAO();
        }
    }
 
    public static ProductorDAO getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    
    public boolean crearProductor(Productor productor) {
        try{
             BasicDBObject info = new BasicDBObject();

        info.put("idProductor", productor.getIdProductor());
        info.put("nombre", productor.getNombre());
        info.put("mail", productor.getMail());
        info.put("direccion", productor.getDireccion());
        info.put("telefono", productor.getTelefono());
        coll.insert(info);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public Productor consultarProductor(String idProductor) {
          BasicDBObject filtro = new BasicDBObject();
        filtro.put("idProductor",idProductor);
        DBCursor cur = coll.find(filtro);
        
        while (cur.hasNext()){
            DBObject o = cur.next();
            return new Productor((String)o.get("idProductor"),(String)o.get("nombre"),
                    (String)o.get("direccion"),(String)o.get("telefono"),(String)o.get("mail"));
        }
        return null;
    }

    public List<Productor> consultarProductores() {
       List<Productor> productores = new ArrayList<Productor>();
         DBCursor cur = coll.find();
         if(cur!=null)
        while(cur.hasNext()) {
           DBObject o = cur.next();
                   
            productores.add(new Productor((String)o.get("idProductor"),(String)o.get("nombre"),
                    (String)o.get("direccion"),(String)o.get("telefono"),(String)o.get("mail")));
        }
        return productores;
    }

    public boolean actualizarProductor(Productor productor) {
        try{
       BasicDBObject filtro = new BasicDBObject();
            filtro.put("idProductor",productor.getIdProductor());
            DBCursor cur = coll.find(filtro);
        
        while (cur.hasNext()){
            DBObject o = cur.next();
            o.put("nombre", productor.getNombre());
            o.put("mail", productor.getMail());
            o.put("direccion", productor.getDireccion());
            o.put("telefono", productor.getTelefono());
            coll.save(o);
            break;
        }
        }catch(Exception e){
            return false;
        }
         return true;
    }

    public boolean eliminarProductor(Productor productor) {
        try{
          BasicDBObject filtro = new BasicDBObject();
            filtro.put("idProductor",productor.getIdProductor());
            DBCursor cur = coll.find(filtro);
        
        while (cur.hasNext()){
            DBObject o = cur.next();
            coll.remove(o);
            break;
        }
        }catch(Exception e){
            return false;
        }
        return true;
    }

    
}
