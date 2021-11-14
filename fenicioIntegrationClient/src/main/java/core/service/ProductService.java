/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import core.dao.ProductoDAO;
import core.model.Producto;
import core.model.entities.ProductoDB;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;

@Singleton
public class ProductService {

    private  ProductoDAO productoDAO;

    public ProductService() {
        this.productoDAO = new ProductoDAO();
    }
    
    public List<Producto> allProducts() {
        List<Producto> productos = new ArrayList<>();
        productoDAO.allProducts().stream().forEach(entity -> productos.add(convertToProducto(entity)));
        return productos;
    }

    private Producto convertToProducto(ProductoDB productoDB) {
        Producto producto = new Producto();
        producto.setCodigo(productoDB.getCodigo());
        producto.setNombre(productoDB.getNombre());
        producto.setGuiaTalles(productoDB.getGuiatalles());
        producto.setFechaCreacion(productoDB.getFechacreacion());
        producto.setMonedaPredeterminada(productoDB.getMonedapredeterminada());

        return producto;
    }

}
