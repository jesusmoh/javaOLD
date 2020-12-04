/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author JOrtiz
 */
@WebFilter(filterName="/StatisticFilter",urlPatterns="/*" )
public class StatisticFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest peticion = (HttpServletRequest) sr;
        ServletContext contexto = sr.getServletContext();
        HashMap<String, Integer> urls;

        if (contexto.getAttribute("estadistica") == null) {
            //creamos un objeto en el contexto
            urls = new HashMap<String, Integer>();

            urls.put(peticion.getRequestURL().toString(), 1);
            contexto.setAttribute("estadistica", urls);
        } else 
        {
            // actualizamos claves e incrementamos
            urls = (HashMap<String, Integer>) contexto.getAttribute("estadistica");
            if (urls.get(peticion.getRequestURL().toString()) == null) 
            {
                urls.put(peticion.getRequestURL().toString(), 1);
            } else {
                urls.put(peticion.getRequestURL().toString(), urls.get(peticion.getRequestURL().toString()) + 1);
            }
        }

        fc.doFilter(sr, sr1);
    }

}
