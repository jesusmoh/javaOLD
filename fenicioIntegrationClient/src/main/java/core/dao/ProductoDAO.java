/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import core.App;
import core.model.entities.ProductoDB;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductoDAO {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU",App.propsDB);

    public ProductoDAO() {
    }

    public List<ProductoDB> allProducts() {
        List<ProductoDB> r = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createNativeQuery("SELECT * FROM productos",ProductoDB.class);
        q.getResultList().stream().forEach((entity)-> {r.add(((ProductoDB) entity));});
        return r;
    }
}
