/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.modelo;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.document.mongodb.mapping.DBRef;
import org.springframework.data.document.mongodb.mapping.Document;
/**
 *
 * @author Jhon
 */
@Document
public class Producto {
    
    public Producto(){
    }
     public Producto(String pid,String nombre,String precio,
             String cantidad,String pidProductor,String pidBodega){
         this.cantidad = cantidad;
         this.nombre = nombre;
         this.pid = pid;
         this.pidBodega = pidBodega;
         this.pidProductor = pidProductor;
         this.precio = precio;
    }
    
    
    @Id
    private String pid;
    private String nombre;
    private String precio;
    private String cantidad;
    private String pidProductor;
    private String pidBodega;

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the pidProductor
     */
    public String getPidProductor() {
        return pidProductor;
    }

    /**
     * @param pidProductor the pidProductor to set
     */
    public void setPidProductor(String pidProductor) {
        this.pidProductor = pidProductor;
    }

    /**
     * @return the pidBodega
     */
    public String getPidBodega() {
        return pidBodega;
    }

    /**
     * @param pidBodega the pidBodega to set
     */
    public void setPidBodega(String pidBodega) {
        this.pidBodega = pidBodega;
    }

    
    
}
    
