/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.certiweb.dao.BodegaDAO;
import org.certiweb.dao.ProductoDAO;
import org.certiweb.dao.ProductorDAO;
import org.certiweb.modelo.Producto;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Jhon
 */
public class ProductoControl  extends AbstractController {
    public ProductoControl() {
        
        
    }
    
    @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
         String function = arg0.getParameter("function");
        ModelAndView modelAndView = new ModelAndView("producto");
	
        if(function==null || function.isEmpty()){
        String id = arg0.getParameter("id");
        String nombre = arg0.getParameter("nombre");
        String precio = arg0.getParameter("precio");
        String cantidad = arg0.getParameter("cant");
        String prov = arg0.getParameter("prod");
        String bod = arg0.getParameter("bode");
        if(id!=null && !id.isEmpty()){
            Producto  b = new Producto();
            b.setCantidad(cantidad);
            b.setPid(id);
            b.setPidBodega(bod);
            b.setNombre(nombre);
            b.setPrecio(precio);
            b.setPidProductor(prov);
            if(arg0.getParameter("act").isEmpty())
            ProductoDAO.getInstance().crearProducto(b);
            else
            ProductoDAO.getInstance().actualizarProducto(b);    
        }
       
        }else if(function.equals("eliminar")){
        String code = arg0.getParameter("id");
            Producto  b = new Producto();
            b.setPid(code);
            ProductoDAO.getInstance().eliminarProducto(b);  
        }else if(function.equals("actualizar")){
            String code = arg0.getParameter("id");
            Producto  b = ProductoDAO.getInstance().consultarProducto(code);
            modelAndView.addObject("valor", b );
            modelAndView.addObject("act", "true");
        }
        
         modelAndView.addObject("lista",ProductoDAO.getInstance().consultarProductos());
         modelAndView.addObject("listaP",ProductorDAO.getInstance().consultarProductores());
         modelAndView.addObject("listaB",BodegaDAO.getInstance().consultarBodega());
        return modelAndView;
    }
}
