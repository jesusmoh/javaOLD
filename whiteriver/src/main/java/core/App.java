/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.model.entities.PCache;
import core.persistence.dao.PCacheFacadeDAO;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

/**
 *
 * @author JOrtiz
 */

@Singleton
@Stateless
@Startup
public class App {

    @EJB
    private PCacheFacadeDAO pCacheFacadeCRUD;

    private PCache imgFtp=null;
    private PCache imgCarpeta=null;

    @PostConstruct
    private void init() {
        
        System.out.print("-------------------- INICIANDO CSERVER --------------------------");
        
        imgFtp = pCacheFacadeCRUD.find("ftp_img");
        imgCarpeta = pCacheFacadeCRUD.find("carpeta_img");

        if (imgFtp == null) {
            pCacheFacadeCRUD.create(new PCache("ftp_img", "http://10.11.44.142:9191/cServer/images/","URL de ip pública"));
        }
         if (imgCarpeta == null) {
            pCacheFacadeCRUD.create(new PCache("carpeta_img", "/mnt/cServer/","Carpeta con las imágenes para publicar"));
        }
    }  


    public PCache getImgFtp() {
        return imgFtp;
    }

    public void setImgFtp(PCache imgFtp) {
        this.imgFtp = imgFtp;
    }

    public PCacheFacadeDAO getpCacheFacadeCRUD() {
        return pCacheFacadeCRUD;
    }

    public void setpCacheFacadeCRUD(PCacheFacadeDAO pCacheFacadeCRUD) {
        this.pCacheFacadeCRUD = pCacheFacadeCRUD;
    }

    public PCache getImgCarpeta() {
        return imgCarpeta;
    }

    public void setImgCarpeta(PCache imgCarpeta) {
        this.imgCarpeta = imgCarpeta;
    }
    
    
}
