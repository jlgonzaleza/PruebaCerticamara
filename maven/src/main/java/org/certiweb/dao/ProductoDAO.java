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
import org.certiweb.modelo.Producto;
import org.certiweb.modelo.Productor;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jhon
 */
public class ProductoDAO  {
     private static ProductoDAO INSTANCE = null;
    DBCollection coll;
     private ProductoDAO() {
        coll = Conexion.getInstance().db.getCollection("producto");
     }
 
   private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ProductoDAO();
        }
    }
 
    public static ProductoDAO getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    
    public boolean crearProducto(Producto producto) {
       try{
             BasicDBObject info = new BasicDBObject();

        info.put("cantidad", producto.getCantidad());
        info.put("nombre",producto.getNombre());
        info.put("pid", producto.getPid());
        info.put("pidBodega", producto.getPidBodega());
        info.put("Precio", producto.getPrecio());
        info.put("pidProductor", producto.getPidProductor());
        coll.insert(info);
        }catch(Exception e){
            return false;
        }
        return true;
    }

   
    public Producto consultarProducto(String idProducto) {
       BasicDBObject filtro = new BasicDBObject();
        filtro.put("pid",idProducto);
        DBCursor cur = coll.find(filtro);
        
        while (cur.hasNext()){
            DBObject o = cur.next();
            return new Producto((String)o.get("pid"),(String)o.get("nombre"),
                    (String)o.get("precio"),(String)o.get("cantidad"),(String)o.get("pidProductor"),
                    (String)o.get("pidBodega"));
        }
        return null;
      }

    public List<Producto> consultarProductos() {
        List<Producto> productores = new ArrayList<Producto>();
         DBCursor cur = coll.find();
         if(cur!=null)
        while(cur.hasNext()) {
           DBObject o = cur.next();
                   
            productores.add(new Producto((String)o.get("pid"),(String)o.get("nombre"),
                    (String)o.get("precio"),(String)o.get("cantidad"),(String)o.get("pidProductor"),
                    (String)o.get("pidBodega")));
        }
        return productores;
    }

    public boolean actualizarProducto(Producto producto) {
        try{
       BasicDBObject filtro = new BasicDBObject();
            filtro.put("pid",producto.getPid());
            DBCursor cur = coll.find(filtro);
        
        while (cur.hasNext()){
            DBObject o = cur.next();
            o.put("nombre", producto.getNombre());
            o.put("precio", producto.getPrecio());
            o.put("cantidad", producto.getCantidad());
            o.put("pidProductor", producto.getPidProductor());
            o.put("pidBodega", producto.getPidBodega());
            coll.save(o);
            break;
        }
        }catch(Exception e){
            return false;
        }
         return true;
    }

    public boolean eliminarProducto(Producto producto) {
       try{
          BasicDBObject filtro = new BasicDBObject();
            filtro.put("pid",producto.getPid());
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

   
    public List<Producto> consultarProductosPorProductor(String idProductor) {
        List<Producto> productores = new ArrayList<Producto>();
        BasicDBObject filtro = new BasicDBObject();
       
        filtro.put("pidProductor",idProductor);
             
        DBCursor cur = coll.find(filtro);
         if(cur!=null)
        while(cur.hasNext()) {
           DBObject o = cur.next();
                   
            productores.add(new Producto((String)o.get("pid"),(String)o.get("nombre"),
                    (String)o.get("precio"),(String)o.get("cantidad"),(String)o.get("pidProductor"),
                    (String)o.get("pidBodega")));
        }
        return productores;
    }

   
    public List<Producto> consultarProductosPorBodega(String iBodega) {
        List<Producto> productores = new ArrayList<Producto>();
        BasicDBObject filtro = new BasicDBObject();
       
        filtro.put("pidBodega",iBodega);
             
        DBCursor cur = coll.find(filtro);
         if(cur!=null)
        while(cur.hasNext()) {
           DBObject o = cur.next();
                   
            productores.add(new Producto((String)o.get("pid"),(String)o.get("nombre"),
                    (String)o.get("precio"),(String)o.get("cantidad"),(String)o.get("pidProductor"),
                    (String)o.get("pidBodega")));
        }
        return productores;
    }
 
    
}
