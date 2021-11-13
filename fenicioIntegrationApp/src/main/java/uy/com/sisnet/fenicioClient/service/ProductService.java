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
import uy.com.sisnet.fenicioClient.model.entities.bo.WebMaProductos;

@Service("ProductService")
public class ProductService {

    @Autowired
    ProductoDAO productoDAO;

    public List<Producto> allProducts() {
        List<Producto> productos = new ArrayList<>();
        productoDAO.allProducts().stream().forEach(entity -> productos.add(convertToProducto(entity)));
        return productos;
    }

    private Producto convertToProducto(WebMaProductos webMaProductos) {
        Producto producto = new Producto();
        producto.setCodigo(webMaProductos.getCodProd().toString());
        producto.setNombre(webMaProductos.getNomProd());
        producto.setGuiaTalles(webMaProductos.getTalle());
        producto.setFechaCreacion(webMaProductos.getFecReg().toString());
        producto.setMonedaPredeterminada("UYU");

        return producto;
    }

}
