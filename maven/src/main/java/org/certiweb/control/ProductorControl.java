/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.certiweb.dao.ProductoDAO;
import org.certiweb.dao.ProductorDAO;
import org.certiweb.modelo.Productor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Jhon
 */
public class ProductorControl extends AbstractController {
    public ProductorControl() {
        
        
    }
    
    @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
         String function = arg0.getParameter("function");
        ModelAndView modelAndView = new ModelAndView("productor");
	
        if(function==null || function.isEmpty()){
        String id = arg0.getParameter("id");
        String nombre = arg0.getParameter("nombre");
        String tel = arg0.getParameter("tel");
        String dir = arg0.getParameter("dir");
        String mail = arg0.getParameter("email");
        if(id!=null && !id.isEmpty()){
            Productor  b = new Productor();
            b.setIdProductor(id);
            b.setMail(mail);
            b.setTelefono(tel);
            b.setNombre(nombre);
            b.setDireccion(dir);
            if(arg0.getParameter("act").isEmpty())
            ProductorDAO.getInstance().crearProductor(b);
            else
            ProductorDAO.getInstance().actualizarProductor(b);    
        }
       
        }else if(function.equals("eliminar")){
        String code = arg0.getParameter("id");
            Productor  b = new Productor();
            b.setIdProductor(code);
            ProductorDAO.getInstance().eliminarProductor(b);  
        }else if(function.equals("actualizar")){
            String code = arg0.getParameter("id");
            Productor  b = ProductorDAO.getInstance().consultarProductor(code);
            modelAndView.addObject("valor", b );
            modelAndView.addObject("act", "true");
            modelAndView.addObject("listaP",ProductoDAO.getInstance().consultarProductosPorProductor(code));
        }
        
         modelAndView.addObject("lista",ProductorDAO.getInstance().consultarProductores());
        return modelAndView;
    }

    
}
