package core.controllers.ui;

import core.model.entities.PCorporativo;
import core.controllers.ui.util.JsfUtil;
import core.controllers.ui.util.JsfUtil.PersistAction;
import core.persistence.dao.PCorporativoFacadeDAO;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("pCorporativoController")
@SessionScoped
public class PCorporativoController implements Serializable {

    @EJB
    private core.persistence.dao.PCorporativoFacadeDAO ejbFacade;
    private List<PCorporativo> items = null;
    private PCorporativo selected;

    public PCorporativoController() {
    }

    public PCorporativo getSelected() {
        return selected;
    }

    public void setSelected(PCorporativo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setPCorporativoPK(new core.model.entities.PCorporativoPK());
    }

    private PCorporativoFacadeDAO getFacade() {
        return ejbFacade;
    }

    public PCorporativo prepareCreate() {
        selected = new PCorporativo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PCorporativoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PCorporativoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PCorporativoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
     public void refreshAll() {
      items = getFacade().findAll();
    }

    public List<PCorporativo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public PCorporativo getPCorporativo(core.model.entities.PCorporativoPK id) {
        return getFacade().find(id);
    }

    public List<PCorporativo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PCorporativo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PCorporativo.class)
    public static class PCorporativoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PCorporativoController controller = (PCorporativoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pCorporativoController");
            return controller.getPCorporativo(getKey(value));
        }

        core.model.entities.PCorporativoPK getKey(String value) {
            core.model.entities.PCorporativoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new core.model.entities.PCorporativoPK();
            key.setCodigoBarra(values[0]);
            key.setRucCliente(values[1]);
            return key;
        }

        String getStringKey(core.model.entities.PCorporativoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodigoBarra());
            sb.append(SEPARATOR);
            sb.append(value.getRucCliente());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PCorporativo) {
                PCorporativo o = (PCorporativo) object;
                return getStringKey(o.getPCorporativoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PCorporativo.class.getName()});
                return null;
            }
        }

    }

}
