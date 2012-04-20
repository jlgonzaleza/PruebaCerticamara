/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import org.springframework.data.document.mongodb.mapping.DBRef;
import org.springframework.data.document.mongodb.mapping.Document;

/**
 *
 * @author Jhon
 */
@Document
public class Productor {
    public Productor(){
       
    }
    public Productor(String idProductor,String nombre,
            String direccion,String telefono,String mail){
       this.idProductor = idProductor;
       this.direccion = direccion;
       this.mail = mail;
       this.nombre = nombre;
       this.telefono = telefono;
    }
    
    @Id
    private String idProductor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;

    /**
     * @return the idProductor
     */
    public String getIdProductor() {
        return idProductor;
    }

    /**
     * @param idProductor the idProductor to set
     */
    public void setIdProductor(String idProductor) {
        this.idProductor = idProductor;
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

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

   
    
}