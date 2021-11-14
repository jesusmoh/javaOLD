/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller;

import core.dto.ProductsDTO;
import core.dto.RequestProductDTO;
import core.model.Data;
import core.model.Producto;
import core.service.ProductService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Singleton
public class ProductsController {
    
    ProductService productService;
    Jsonb jsonb ;
    
    @PostConstruct
    public void ini(){
      productService= new ProductService();
      jsonb= JsonbBuilder.create();
    }
    
    @GET
    @Path("/productos")
    @Produces("application/json")
    @Consumes("application/json")
    public ProductsDTO getStudentInformation(String fenicioJson) {
        
        RequestProductDTO requestProductDTO;
        ProductsDTO productsDTO = new ProductsDTO();
        Data dataForProductsDTO = new Data();
        
        requestProductDTO = jsonb.fromJson(fenicioJson, RequestProductDTO.class);
        List<Producto> productList= productService.allProducts();
        
        dataForProductsDTO.setProductos(productList);
        productsDTO.setData(dataForProductsDTO);
        productsDTO.setIdSolicitud(requestProductDTO.getIdSolicitud());
        productsDTO.setStatus("OK");
        productsDTO.setMensaje("JSON RECIVE "+ fenicioJson );
        productsDTO.setIdSolicitud(requestProductDTO.getIdSolicitud());
        
        return  productsDTO;
    }
}
