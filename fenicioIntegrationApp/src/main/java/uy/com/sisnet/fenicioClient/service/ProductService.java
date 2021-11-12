/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.sisnet.fenicioClient.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.sisnet.fenicioClient.dao.ProductoDAO;
import uy.com.sisnet.fenicioClient.model.Producto;
import uy.com.sisnet.fenicioClient.model.entities.ProductoDB;

@Service("ProductService")
public class ProductService {

    @Autowired
    ProductoDAO productoDAO;

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
