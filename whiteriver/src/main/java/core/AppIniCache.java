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

 */
@Singleton
@Stateless
@Startup
public class AppIniCache {

    @EJB
    private PCacheFacadeDAO pCacheFacadeCRUD;

    private PCache imgFtp = null;
    private PCache imgCarpeta = null;
    private PCache imgBase64 = null;
    private PCache userApp = null;
    private PCache passApp = null;

    @PostConstruct
    private void init() {

        System.out.print("-------------------- INICIANDO CSERVER --------------------------");

        imgFtp = pCacheFacadeCRUD.find("ftp_img");
        imgCarpeta = pCacheFacadeCRUD.find("carpeta_img");
        imgBase64 = pCacheFacadeCRUD.find("img_base_64");
        userApp = pCacheFacadeCRUD.find("user_app");
        passApp = pCacheFacadeCRUD.find("pass_app");

        if (imgFtp == null) {
            pCacheFacadeCRUD.create(new PCache("ftp_img", "http://10.11.44.142:9191/cServer/images/", "URL de ip pública"));
        }
        if (imgCarpeta == null) {
            pCacheFacadeCRUD.create(new PCache("carpeta_img", "/mnt/cServer/", "Carpeta con las imágenes para publicar"));
        }
        if (imgBase64 == null) {
            pCacheFacadeCRUD.create(new PCache("img_base_64", "true", " url o formanto 64 en el JSON"));
        }
         if (userApp == null) {
            pCacheFacadeCRUD.create(new PCache("user_app", "99999", " usuario web y rest api"));
        }
        if (passApp == null) {
            pCacheFacadeCRUD.create(new PCache("pass_app", "1278202", " pass web y rest api"));
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

    public PCache getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(PCache imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public PCache getUserApp() {
        return userApp;
    }

    public void setUserApp(PCache userApp) {
        this.userApp = userApp;
    }

    public PCache getPassApp() {
        return passApp;
    }

    public void setPassApp(PCache passApp) {
        this.passApp = passApp;
    }

}
