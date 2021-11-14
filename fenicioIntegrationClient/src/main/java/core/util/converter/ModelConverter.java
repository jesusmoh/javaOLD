/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.util.converter;

import core.model.Producto;
import core.model.entities.ProductoDB;

/**
 *
 * @author jesus
 */
public class ModelConverter {
    
    public static Producto convertToProducto(ProductoDB productoDB)
    {
       Producto producto= new Producto();
       producto.setCodigo(productoDB.getCodigo());
       producto.setNombre(productoDB.getNombre());
       producto.setGuiaTalles(productoDB.getGuiatalles());
       producto.setFechaCreacion(productoDB.getFechacreacion());
       producto.setMonedaPredeterminada(productoDB.getMonedapredeterminada());
 
       return producto;
    }
}
