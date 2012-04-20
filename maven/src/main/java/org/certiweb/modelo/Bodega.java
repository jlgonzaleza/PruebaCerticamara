/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.modelo;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.document.mongodb.mapping.DBRef;
import org.springframework.data.document.mongodb.mapping.Document;

/**
 *
 * @author Jhon
 */
@Document
public class Bodega{
    public Bodega(){
    }
    
    public Bodega(String codigo, String dir){
        this.codigo = codigo;
        direccion = dir;
    }   
    @Id
    private String codigo;
    private String direccion;
    

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
   
   
}
