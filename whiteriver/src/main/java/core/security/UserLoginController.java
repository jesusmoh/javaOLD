/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.security;

import core.AppIniCache;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author JOrtiz
 */
@Named
@RequestScoped
public class UserLoginController {

    @EJB
    private AppIniCache appIniCache;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(ActionEvent event) {
        FacesMessage message = null;
        boolean loggedIn = false;
        String redireccion = null;

        String server_username = "desconocido";
        server_username = "99999";
        String server_password = "1278202";

        server_username = appIniCache.getUserApp().getValue();
        server_password = appIniCache.getPassApp().getValue();

        if (username != null && (username.equals(server_username) && password != null && password.equals(server_password))) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido " + username, username);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", server_username);
            redireccion = "template.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de Logeo", "Contraseña invalida");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        return redireccion;
    }

    public void verificarSesion() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            String usuario = (String) fc.getExternalContext().getSessionMap().get("user");
            if (usuario == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/cServer/faces/index.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
