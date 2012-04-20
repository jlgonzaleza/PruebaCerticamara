/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiweb.control;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.certiweb.dao.BodegaDAO;
import org.certiweb.dao.ProductoDAO;
import org.certiweb.modelo.Bodega;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Jhon
 */
public class BodegaControl extends AbstractController {
    public BodegaControl() {
        
        
    }
    
    @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
         String function = arg0.getParameter("function");
        ModelAndView modelAndView = new ModelAndView("bodega");
	
        if(function==null || function.isEmpty()){
        String code = arg0.getParameter("code");
        String dir = arg0.getParameter("dir");
        if(code!=null && !code.isEmpty() && dir!=null && !dir.isEmpty()){
            Bodega  b = new Bodega();
            b.setCodigo(code);
            b.setDireccion(dir);
            if(arg0.getParameter("act").isEmpty())
            BodegaDAO.getInstance().crearBodega(b);
            else
            BodegaDAO.getInstance().actualizarBodega(b);    
        }
       
        }else if(function.equals("eliminar")){
        String code = arg0.getParameter("id");
            Bodega  b = new Bodega();
            b.setCodigo(code);
            BodegaDAO.getInstance().eliminarBodega(b);    
        }else if(function.equals("actualizar")){
            String code = arg0.getParameter("id");
            Bodega  b = BodegaDAO.getInstance().consultarBodega(code);
            modelAndView.addObject("valor", b );
            modelAndView.addObject("act", "true");
            modelAndView.addObject("listaP",ProductoDAO.getInstance().consultarProductosPorBodega(code));
        }
        
         modelAndView.addObject("lista", BodegaDAO.getInstance().consultarBodega());
        return modelAndView;
    }

    
    
    
}
