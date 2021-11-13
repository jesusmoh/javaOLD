/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.sisnet.fenicioClient.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uy.com.sisnet.fenicioClient.dto.ProductsDTO;
import uy.com.sisnet.fenicioClient.dto.RequestProductsDTO;
import uy.com.sisnet.fenicioClient.model.Data;
import uy.com.sisnet.fenicioClient.model.Producto;
import uy.com.sisnet.fenicioClient.service.ProductService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;
    final private ObjectMapper mapper = new ObjectMapper();
    final static Logger log = Logger.getLogger(ProductsController.class.getName());

    @PostConstruct
    public void ini() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @RequestMapping(value = "/productos", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ProductsDTO getStudentInformation(@RequestBody String fenicioJson) {

        RequestProductsDTO requestProductDTO = null;
        ProductsDTO productsDTO = new ProductsDTO();
        Data dataForProductsDTO = new Data();

        try {
            requestProductDTO = mapper.readValue(fenicioJson, RequestProductsDTO.class);
        } catch (JsonProcessingException ex) {
           log.severe(ex.getMessage());
        }

        List<Producto> productList = productService.allProducts();

        dataForProductsDTO.setProductos(productList);
        dataForProductsDTO.setDesde(requestProductDTO.getDesde());
        dataForProductsDTO.setTotal(requestProductDTO.getTotal());
        productsDTO.setData(dataForProductsDTO);
        productsDTO.setStatus("OK");
        productsDTO.setMensaje("JSON RECIVE FROM FENICIO " + fenicioJson);
        productsDTO.setIdSolicitud(requestProductDTO.getIdSolicitud());

        log.info(ToStringBuilder.reflectionToString(productsDTO.getData(), ToStringStyle.JSON_STYLE));
        return productsDTO;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Server error")
    public Object handleError(HttpServletRequest req, Exception ex) {
        log.severe(ex.getMessage());
        Object errorObject = new Object();
        return errorObject;
    }
}
