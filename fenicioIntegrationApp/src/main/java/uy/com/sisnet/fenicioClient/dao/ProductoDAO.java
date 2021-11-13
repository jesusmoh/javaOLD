/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.sisnet.fenicioClient.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import uy.com.sisnet.fenicioClient.model.entities.bo.WebMaProductos;

@Component
public class ProductoDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
     public List<WebMaProductos> allProducts() {
        List<WebMaProductos> r = new ArrayList<>();
        Query q = entityManager.createNativeQuery("SELECT * FROM web_ma_productos",WebMaProductos.class);
        q.getResultList().stream().forEach((entity)-> {r.add(((WebMaProductos) entity));});
        return r;
    }

}
