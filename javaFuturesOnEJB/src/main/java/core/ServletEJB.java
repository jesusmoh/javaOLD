/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOrtiz
 */
@WebServlet("/ServletEJB")
public class ServletEJB extends HttpServlet{

    @EJB
    ServicioEJB1 servicio1;
     
    @EJB
    ServicioEJB2 servicio2;
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        
        PrintWriter pw=response.getWriter();
        pw.println("ini");
        Future<String> futuro1=servicio1.getMensaje1();
        Future<String> futuro2= servicio2.getMensaje2();
         
        while(!futuro1.isDone() && !futuro2.isDone()) {
             
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         
         
        
        try {
            pw.println(futuro1.get());
            pw.println(futuro2.get());
             
             
        } catch (InterruptedException e) {
         
            e.printStackTrace();
        } catch (ExecutionException e) {
         
            e.printStackTrace();
        }
    }
     
}
