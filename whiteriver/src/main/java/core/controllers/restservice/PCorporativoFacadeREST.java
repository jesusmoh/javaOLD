/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controllers.restservice;

import core.App;
import core.model.dto.PCorporativoDTO;
import core.persistence.AbstractFacade;
import core.model.entities.PCorporativo;
import core.model.entities.PCorporativoPK;
import core.model.util.StringSimilarity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javax.ws.rs.core.PathSegment;
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
    private App app;
    private final ModelMapper modelMapper = new ModelMapper();

    @PersistenceContext(unitName = "core_cServer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private PCorporativo getMultipleKey(PathSegment pathSegment) {

        PCorporativoPK pkey = new PCorporativoPK();
        PCorporativo key = new PCorporativo(pkey);

        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();

        java.util.List<String> rucCliente = map.get("rucCliente");
        if (rucCliente != null && !rucCliente.isEmpty()) {
            key.getPCorporativoPK().setRucCliente((rucCliente.get(0)));
        }

        java.util.List<String> codigoBarra = map.get("codigoBarra");
        if (codigoBarra != null && !codigoBarra.isEmpty()) {
            key.getPCorporativoPK().setRucCliente((codigoBarra.get(0)));
        }

        java.util.List<String> rucProveedor = map.get("rucProveedor");
        if (rucProveedor != null && !rucProveedor.isEmpty()) {
            key.setRucProveedor((rucProveedor.get(0)));
        }

        java.util.List<String> codigoArticuloProveedor = map.get("codigoArticuloProveedor");
        if (codigoArticuloProveedor != null && !codigoArticuloProveedor.isEmpty()) {
            key.setCodigoArticuloProveedor((codigoArticuloProveedor.get(0)));
        }
        java.util.List<String> nombreProducto = map.get("nombreProducto");
        if (nombreProducto != null && !nombreProducto.isEmpty()) {
            key.setNombreProducto((nombreProducto.get(0)));
        }
        java.util.List<String> nombreProveedor = map.get("nombreProveedor");
        if (nombreProveedor != null && !nombreProveedor.isEmpty()) {
            key.setNombreProveedor((nombreProveedor.get(0)));
        }
        java.util.List<String> codigoIva = map.get("codigoIva");
        if (codigoIva != null && !codigoIva.isEmpty()) {
            key.setCodigoIva(new Short(codigoIva.get(0)));
        }
        java.util.List<String> rsocialProveedor = map.get("rsocialProveedor");
        if (rsocialProveedor != null && !rsocialProveedor.isEmpty()) {
            key.setRsocialProveedor(rsocialProveedor.get(0));
        }
        return key;
    }

    public PCorporativoFacadeREST() {
        super(PCorporativo.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Crea Producto Dado un JSON", notes = "Crea un producto dado un JSON")
    public void createP(PCorporativoDTO entity) {
        super.create(modelMapper.map(entity, PCorporativo.class));
    }

    @PUT
    @Path("{id}")
    @ApiOperation(value = "Actualiza Producto Dado un JSON", notes = "Actualiza un producto dado un JSON y el codigoBarra EAN13 + el campo rucCliente ")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(
            @ApiParam(example = "codigoBarra=7730744095194&rucCliente=214102650015")
            @PathParam("id") String id, 
            PCorporativoDTO entity) {
        
        Map<String, String> p = getQueryMap(id);
        PCorporativoPK pk = new PCorporativoPK();
        pk.setCodigoBarra(p.get("codigoBarra"));
        pk.setRucCliente(p.get("rucCliente"));
        PCorporativo pp =modelMapper.map(entity, PCorporativo.class);
        pp.setPCorporativoPK(pk);
        super.edit(pp);
    }

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "Elimina Producto", notes = "Elimina un producto dado un valor para el campo codigoBarra EAN13 y otro valor para el campo rucCliente de de la empresa modelo ")
    public void remove(
            @ApiParam(example = "codigoBarra=7730744095194&rucCliente=214102650015")
            @PathParam("id") String id) 
    {
        Map<String, String> p = getQueryMap(id);
        PCorporativoPK pk = new PCorporativoPK();
        pk.setCodigoBarra(p.get("codigoBarra"));
        pk.setRucCliente(p.get("rucCliente"));
        super.remove(new PCorporativo(pk));
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "Producto por código de barra y un ruc", notes = "Obtiene un producto dado un valor para el campo codigoBarra EAN13 y otro valor para el campo rucCliente de de la empresa modelo.")
    @Produces({MediaType.APPLICATION_JSON})
    public PCorporativoDTO find(
            @ApiParam(example = "codigoBarra=7730744095194&rucCliente=214102650015")
            @PathParam("id") String id) 
    {
        Map<String, String> p = getQueryMap(id);
        PCorporativoPK pk = new PCorporativoPK();
        pk.setCodigoBarra(p.get("codigoBarra"));
        pk.setRucCliente(p.get("rucCliente"));
        PCorporativoDTO pro = new PCorporativoDTO();
        pro =generateDTO(super.find(pk));
        return pro;
    }

    @GET
    @Path("codigobarra/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Producto por código de barra", notes = "Obtiene el mejor producto dado un código de barra EAN13.")
    public PCorporativoDTO find2(
            @ApiParam(example = "7730744095194")
            @PathParam("id") String id)
    {
        PCorporativoDTO pro = new PCorporativoDTO();
        PCorporativo entity = getProductoPorCodigoBarra(id);
        pro = generateDTO(entity);
        return pro;
    }

    @GET
    @Path("proveedorarticulo/{id}")
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

    /*
    A EVALUAR
    
    @GET
    @Path("similitud/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public PCorporativoDTO findSimilitud(@PathParam("id") String id) {

        Map<String, String> p = getQueryMap(id);
        PCorporativoPK pk = new PCorporativoPK();
        PCorporativo key = new PCorporativo(pk);

        return generateDTO(getProductoByProveedor(key.getNombreProducto(), key.getNombreProveedor(), key.getCodigoIva(), key.getRsocialProveedor()));
    }
     */

    @Override
    protected EntityManager getEntityManager() {
        return em;
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
