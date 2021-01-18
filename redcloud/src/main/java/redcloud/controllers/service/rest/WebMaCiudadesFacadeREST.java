/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcloud.controllers.service.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.modelmapper.ModelMapper;
import redcloud.model.dto.WebMaCiudadesDTO;
import redcloud.model.persistence.entities.WebMaCiudades;

/**
 *
 * @author jesus
 */
@Stateless
@Path("redcloud.model.entities.webmaciudades")
public class WebMaCiudadesFacadeREST extends AbstractFacadeRest<WebMaCiudades> {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;
    ModelMapper modelMapper = new ModelMapper();
    
    @Inject
    @Metric
    private Counter fails;
    
    @Inject
    @ConfigProperty(name = "app.native.countsms")
    private String countsms;
    

    public WebMaCiudadesFacadeREST() {
        super(WebMaCiudades.class);
    }

    @POST
    @Counted
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void create(@Valid WebMaCiudadesDTO dto) {
        WebMaCiudades entity = modelMapper.map(dto, WebMaCiudades.class);
        super.create(entity);
    }

    @PUT
    @Counted
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, WebMaCiudades entity) {
        super.edit(entity);
    }

    @DELETE
    @Counted
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Counted
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public WebMaCiudadesDTO find(@PathParam("id") Integer id) {
        WebMaCiudadesDTO dto = modelMapper.map(super.find(id), WebMaCiudadesDTO.class);
        return dto;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<WebMaCiudades> findAll() {
        return super.findAll();
    }

    @GET
    @Counted
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<WebMaCiudades> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

   
    @GET
    @Path("count")
    @Counted
    @Timeout(300)
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "fallback")
    @Operation(description = " descripcion de web services count")
    public String countREST() {
        return countsms+" "+ String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public String fallback()
    {
        fails.inc();
        return "ws fail";
    }
    
}
