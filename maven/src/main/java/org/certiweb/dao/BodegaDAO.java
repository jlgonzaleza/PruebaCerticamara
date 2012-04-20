/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.dao;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.certiweb.modelo.Bodega;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.document.mongodb.query.Criteria.where;
import org.springframework.stereotype.Component;
/**
 *
 * @author Jhon
 */
public class BodegaDAO {
    private static BodegaDAO INSTANCE = null;
    DBCollection coll;
     private BodegaDAO() {
     
         coll = Conexion.getInstance().db.getCollection("bodega");
        
     }
 
   private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new BodegaDAO();
        }
    }
 
    public static BodegaDAO getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public boolean crearBodega(Bodega bodega) {
        try{
        
        BasicDBObject info = new BasicDBObject();

        info.put("codigo", bodega.getCodigo());
        info.put("direccion", bodega.getDireccion());
        coll.insert(info);
        
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public Bodega consultarBodega(String idBodega) {
        BasicDBObject filtro = new BasicDBObject();
        filtro.put("codigo",idBodega);
        DBCursor cur = coll.find(filtro);
        
        while (cur.hasNext()){
            DBObject o = cur.next();
            return new Bodega((String)o.get("codigo"),(String)o.get("direccion"));
        }
        return null;
    }

    public List<Bodega> consultarBodega() {
        List<Bodega> bodegas = new ArrayList<Bodega>();
         DBCursor cur = coll.find();
         if(cur!=null)
        while(cur.hasNext()) {
           DBObject o = cur.next();
                   
            bodegas.add(new Bodega((String)o.get("codigo"),(String)o.get("direccion")));
        }
        // Execute the query and find all matching entries
        return bodegas;
    }

    public boolean actualizarBodega(Bodega bodega) {
        try{
       BasicDBObject filtro = new BasicDBObject();
            filtro.put("codigo",bodega.getCodigo());
            DBCursor cur = coll.find(filtro);
        
        while (cur.hasNext()){
            DBObject o = cur.next();
            o.put("direccion",bodega.getDireccion() );
            coll.save(o);
            break;
        }
        }catch(Exception e){
            return false;
        }
         return true;
    }

    public boolean eliminarBodega(Bodega bodega) {
        try{
          BasicDBObject filtro = new BasicDBObject();
            filtro.put("codigo",bodega.getCodigo());
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
