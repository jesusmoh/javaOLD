/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controllers.restservice;

import core.AppIniCache;
import core.model.dto.PCorporativoDTO;
import core.persistence.AbstractFacade;
import core.model.entities.PCorporativo;
import core.model.entities.PCorporativoPK;
import core.model.util.StringSimilarity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

/**
 *
 * @author JOrtiz
 */
@Stateless
@Path("core.domain.pcorporativo")
@Api(value = "WebServices")
public class PCorporativoFacadeREST extends AbstractFacade<PCorporativo> {

    @EJB
    private AppIniCache app;
    private final ModelMapper modelMapper = new ModelMapper();

    @PersistenceContext(unitName = "core_cServer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PCorporativoFacadeREST() {
        super(PCorporativo.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("99999")
    @ApiOperation(value = "Crea Producto Dado un JSON", notes = "Crea un producto dado un JSON")
    public Response createP(PCorporativoDTO entity) {
        PCorporativo p = new PCorporativo();
        p = modelMapper.map(entity, PCorporativo.class);
        PCorporativoPK pk = new PCorporativoPK(entity.getCodigoBarra(), entity.getRucCliente());
        p.setPCorporativoPK(pk);
        if (super.find(p.getPCorporativoPK()) == null) {
            if (app.getImgBase64().getValue().equalsIgnoreCase("true") && entity.getImageBase64().equalsIgnoreCase("true")) {
                try {
                    byte[] data = Base64.getDecoder().decode(entity.getImagen());
                    byte[] data1 = Base64.getDecoder().decode(entity.getImagen1());
                    byte[] data2 = Base64.getDecoder().decode(entity.getImagen2());
                    byte[] data3 = Base64.getDecoder().decode(entity.getImagen3());
                    OutputStream stream = new FileOutputStream(app.getImgCarpeta().getValue() + entity.getRucCliente() + "/recursos/imagenes/bo/" + entity.getCodigoProductoCliente() + ".JPG");
                    OutputStream stream1 = new FileOutputStream(app.getImgCarpeta().getValue() + entity.getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-1.JPG");
                    OutputStream stream2 = new FileOutputStream(app.getImgCarpeta().getValue() + entity.getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-2.JPG");
                    OutputStream stream3 = new FileOutputStream(app.getImgCarpeta().getValue() + entity.getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-3.JPG");
                    stream.write(data);
                    stream1.write(data1);
                    stream2.write(data2);
                    stream3.write(data3);
                } catch (FileNotFoundException ex) {
                    System.out.println("" + ex.getMessage());
                    return Response.status(400).entity(entity).build();
                } catch (IOException ex) {
                    System.out.println("" + ex.getMessage());
                    return Response.status(400).entity(entity).build();
                }
            }
            super.create(p);
            return Response.status(200).entity(entity).build();
        } else {
            return Response.status(400).entity(entity).build();
        }
    }

    @PUT
    @Path("{id}")
    @RolesAllowed("99999")
    @ApiOperation(value = "Actualiza Producto Dado un JSON", notes = "Actualiza un producto dado un JSON y el codigoBarra EAN13 + el campo rucCliente ")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(
            @ApiParam(example = "codigoBarra=7730744095194&rucCliente=214102650015")
            @PathParam("id") String id,
            PCorporativoDTO entity
    ) {
        Map<String, String> p = getQueryMap(id);
        PCorporativoPK pk = new PCorporativoPK();
        pk.setCodigoBarra(p.get("codigoBarra"));
        pk.setRucCliente(p.get("rucCliente"));
        PCorporativo pp = modelMapper.map(entity, PCorporativo.class);
        pp.setPCorporativoPK(pk);
        if (super.find(pk) != null) {
             if (app.getImgBase64().getValue().equalsIgnoreCase("true") && entity.getImageBase64().equalsIgnoreCase("true")) {
                try {
                    byte[] data = Base64.getDecoder().decode(entity.getImagen());
                    byte[] data1 = Base64.getDecoder().decode(entity.getImagen1());
                    byte[] data2 = Base64.getDecoder().decode(entity.getImagen2());
                    byte[] data3 = Base64.getDecoder().decode(entity.getImagen3());
                    OutputStream stream = new FileOutputStream(app.getImgCarpeta().getValue() + entity.getRucCliente() + "/recursos/imagenes/bo/" + entity.getCodigoProductoCliente() + ".JPG");
                    OutputStream stream1 = new FileOutputStream(app.getImgCarpeta().getValue() + entity.getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-1.JPG");
                    OutputStream stream2 = new FileOutputStream(app.getImgCarpeta().getValue() + entity.getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-2.JPG");
                    OutputStream stream3 = new FileOutputStream(app.getImgCarpeta().getValue() + entity.getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-3.JPG");
                    stream.write(data);
                    stream1.write(data1);
                    stream2.write(data2);
                    stream3.write(data3);
                } catch (FileNotFoundException ex) {
                    System.out.println("" + ex.getMessage());
                    return Response.status(400).entity(entity).build();
                } catch (IOException ex) {
                    System.out.println("" + ex.getMessage());
                    return Response.status(400).entity(entity).build();
                }
            }
            super.edit(pp);
            return Response.status(200).entity(entity).build();
        } else {
            return Response.status(400).entity(entity).build();
        }
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed("99999")
    @ApiOperation(value = "Elimina Producto", notes = "Elimina un producto dado un valor para el campo codigoBarra EAN13 y otro valor para el campo rucCliente de de la empresa modelo ")
    public Response remove(
            @ApiParam(example = "codigoBarra=7730744095194&rucCliente=214102650015")
            @PathParam("id") String id
    ) {
        Map<String, String> p = getQueryMap(id);
        PCorporativoPK pk = new PCorporativoPK();
        pk.setCodigoBarra(p.get("codigoBarra"));
        pk.setRucCliente(p.get("rucCliente"));

        PCorporativo toDelete = super.find(pk);
        if (toDelete != null) {
            super.remove(toDelete);
            return Response.status(200).entity(toDelete).build();
        } else {
            return Response.status(400).entity(pk).build();
        }
    }

    @GET
    @Path("{id}")
    @RolesAllowed("99999")
    @ApiOperation(value = "Producto por código de barra y un ruc", notes = "Obtiene un producto dado un valor para el campo codigoBarra EAN13 y otro valor para el campo rucCliente de de la empresa modelo.")
    @Produces({MediaType.APPLICATION_JSON})
    public PCorporativoDTO find(
            @ApiParam(example = "codigoBarra=7730744095194&rucCliente=214102650015")
            @PathParam("id") String id
    ) {
        Map<String, String> p = getQueryMap(id);
        PCorporativoPK pk = new PCorporativoPK();
        pk.setCodigoBarra(p.get("codigoBarra"));
        pk.setRucCliente(p.get("rucCliente"));
        PCorporativoDTO pro = new PCorporativoDTO();
        PCorporativo entity = super.find(pk);
        if (entity.getPCorporativoPK() != null && entity.getNombreProducto() != null && entity.getImagen() != null) {
            pro = generateDTO(entity);
        } else {
            pro = new PCorporativoDTO();
        }
        return pro;
    }

    @GET
    @Path("codigobarra/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed("99999")
    @ApiOperation(value = "Producto por código de barra", notes = "Obtiene el mejor producto dado un código de barra EAN13.")
    public PCorporativoDTO find2(
            @ApiParam(example = "7730744095194")
            @PathParam("id") String id
    ) {
        PCorporativoDTO pro = new PCorporativoDTO();
        PCorporativo entity = getProductoPorCodigoBarra(id);
        if (entity.getPCorporativoPK() != null && entity.getNombreProducto() != null && entity.getImagen() != null) {
            pro = generateDTO(entity);
        } else {
            pro = new PCorporativoDTO();
        }
        return pro;
    }
    
    public PCorporativoDTO fPCorporativoDTO() {
        PCorporativoDTO r = new PCorporativoDTO();
        return r;
    }

    @GET
    @Path("proveedorarticulo/{id}")
    @RolesAllowed("99999")
    @ApiOperation(value = "Códigos de barras de un artículo y proveedor", notes = "Obtiene los productos dado un codigoArticuloProveedor y el rucProveedor")
    @Produces({MediaType.APPLICATION_JSON})
    public List<PCorporativoDTO> findProveedorAndArticulo(
            @ApiParam(example = "codigoArticuloProveedor=9519-01456&rucProveedor=215084930013")
            @PathParam("id") String id) {
        Map<String, String> p = getQueryMap(id);
        return generateDTOlist(getProductosByProveedor(p.get("rucProveedor"), p.get("codigoArticuloProveedor")));
    }

    @GET
    @Path("ruccliente/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed("99999")
    @ApiOperation(value = "Producto por rucCliente", notes = "Obtiene los productos dado un rucCliente modelo")
    public List<PCorporativoDTO> findArticulosPorRutCliente(
            @ApiParam(example = "214102650015")
            @PathParam("id") String id) {

        List<PCorporativoDTO> l = new ArrayList<PCorporativoDTO>();
        List<PCorporativo> entities = new ArrayList<PCorporativo>();
        entities = getProductosPorRutCliente(id);
        l = generateDTOlist(entities);
        return l;

    }

    @GET
    @Path("similitud/{id}")
    @RolesAllowed("99999")
    @Produces({MediaType.APPLICATION_JSON})
    public PCorporativoDTO findSimilitud(@PathParam("id") String id) {

        Map<String, String> p = getQueryMap(id);
        PCorporativoPK pk = new PCorporativoPK();
        PCorporativo key = new PCorporativo(pk);

        return generateDTO(getProductoByProveedor(key.getNombreProducto(), key.getNombreProveedor(), key.getCodigoIva(), key.getRsocialProveedor()));
    }

    public PCorporativo getProductoPorCodigoBarra(String codigobarra) {
        PCorporativo r = new PCorporativo();
        List<PCorporativo> resultset = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("PCorporativo.findByCodigoBarra");
            query.setParameter("codigoBarra", codigobarra);
            resultset = (List<PCorporativo>) query.getResultList();
            if (resultset.size() > 0) {
                // LOGICA QUE DETERMINA MEJOR PRODUCTO
                r = resultset.get(0);
            } else {
                r = resultset.get(0);

            }

        } catch (Exception ex) {
            return r;
        }
        return r;
    }

    public List<PCorporativo> getProductosPorRutCliente(String rucCliente) {
        List<PCorporativo> resultset = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("PCorporativo.findByRucCliente");
            query.setParameter("rucCliente", rucCliente);
            resultset = (List<PCorporativo>) query.getResultList();
        } catch (Exception ex) {
            return resultset;
        }
        return resultset;
    }

    public static Map<String, String> getQueryMap(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    public List<PCorporativo> getProductosByProveedor(String rucProveedor, String codigoArticuloProveedor) {
        List<PCorporativo> r = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("PCorporativo.findByRucProveedorAndCodigoArticuloProveedor");
            query.setParameter("rucProveedor", rucProveedor);
            query.setParameter("codigoArticuloProveedor", codigoArticuloProveedor);
            r = (List<PCorporativo>) query.getResultList();
        } catch (Exception ex) {
            return r;
        }
        return r;
    }

    public PCorporativo getProductoByProveedor(String nombreProducto, String nombreProveedor, Short codigoIva, String rsocialProveedor) {
        List<PCorporativo> r = new ArrayList<>();
        PCorporativo p = new PCorporativo();
        try {
            Query query = em.createNamedQuery("PCorporativo.findByCodigoIva");
            query.setParameter("codigoIva", codigoIva);
            r = (List<PCorporativo>) query.getResultList();
        } catch (Exception ex) {
            return p;
        }
        double importancia = 0;
        String barcode = "";

        for (PCorporativo r1 : r) {
            double v = 0.0;
            v = 3 * StringSimilarity.similarity(r1.getNombreProducto(), nombreProducto);
            v = v + StringSimilarity.similarity(r1.getNombreProveedor(), nombreProveedor);
            v = v + StringSimilarity.similarity(r1.getRsocialProveedor(), rsocialProveedor);
            if (v > importancia) {
                importancia = v;
                barcode = r1.getPCorporativoPK().getCodigoBarra();
            }
        }

        p = getProductoPorCodigoBarra(barcode);
        return p;
    }

    public PCorporativoDTO generateDTO(PCorporativo entity) {
        PCorporativoDTO r = new PCorporativoDTO();
        r = modelMapper.map(entity, PCorporativoDTO.class);
        r.setCodigoBarra(entity.getPCorporativoPK().getCodigoBarra());
        r.setRucCliente(entity.getPCorporativoPK().getRucCliente());
        if (entity.getImagen1().equalsIgnoreCase("S")) {
            r.setImagen(app.getImgFtp().getValue() + entity.getPCorporativoPK().getRucCliente() + "/recursos/imagenes/bo/" + entity.getCodigoProductoCliente() + ".jpg");
        }
        if (entity.getImagen1().equalsIgnoreCase("S")) {
            r.setImagen1(app.getImgFtp().getValue() + entity.getPCorporativoPK().getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-1.jpg");
        }
        if (entity.getImagen2().equalsIgnoreCase("S")) {
            r.setImagen2(app.getImgFtp().getValue() + entity.getPCorporativoPK().getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-2.jpg");
        }
        if (entity.getImagen3().equalsIgnoreCase("S")) {
            r.setImagen3(app.getImgFtp().getValue() + entity.getPCorporativoPK().getRucCliente() + "/recursos/imagenes/web/" + entity.getCodigoProductoCliente() + "-3.jpg");
        }
        return r;

    }

    public List<PCorporativoDTO> generateDTOlist(List<PCorporativo> entities) {
        List<PCorporativoDTO> l = new ArrayList<PCorporativoDTO>();
        PCorporativoDTO p;
        for (PCorporativo e : entities) {
            p = generateDTO(e);
            l.add(p);
        }
        return l;
    }

}
