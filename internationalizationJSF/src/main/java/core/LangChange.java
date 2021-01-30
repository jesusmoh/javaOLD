/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author JOrtiz
 */
@Named(value = "langChange")
@SessionScoped
public class LangChange implements Serializable {

    public LangChange() {
    }

    private String languagecode;
    private static Map<String, Object> countries;

    static {
        countries = new LinkedHashMap<String, Object>();
        countries.put("English", Locale.ENGLISH);
        countries.put("Japanese", Locale.JAPANESE);
    }

    public void setCountries(Map<String, Object> countries) {
        LangChange.countries = countries;
    }

    public Map<String, Object> getCountries() {
        return countries;
    }

    public void setLanguagecode(String languagecode) {
        this.languagecode = languagecode;
    }

    public String getLanguagecode() {
        return languagecode;
    }

    public void countryLocaleCodeChanged(ValueChangeEvent take_event) {
        String new_language_code = take_event.getNewValue().toString();
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(new_language_code)) {
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
    }
}
