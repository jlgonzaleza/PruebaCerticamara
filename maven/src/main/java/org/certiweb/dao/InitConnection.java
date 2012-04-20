/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.dao;

import org.certiweb.modelo.Bodega;
import org.certiweb.modelo.Producto;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jhon
 */
@Transactional
public class InitConnection {
  
 @Resource(name="mongoTemplate")
 private MongoTemplate mongoTemplate;
   
    
 private void init() {
  
     
  Bodega p = new Bodega ();
  p.setCodigo("10000");
  p.setDireccion("cra 30");
  mongoTemplate.insert(p, "bodega");
  // Insert to db
 
  
 }
}
