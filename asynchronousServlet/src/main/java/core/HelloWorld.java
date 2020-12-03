/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOrtiz
 */
@WebServlet(name = "HelloWorld", urlPatterns = {"/HelloWorld"},asyncSupported = true)
public class HelloWorld extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            final PrintWriter pw = response.getWriter();
            System.out.println("Main Thread :" + Thread.currentThread().getName());
            final AsyncContext contextAsynchronous = request.startAsync();
            contextAsynchronous.setTimeout(12000);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorld Asynchronous</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorld at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            contextAsynchronous.start(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <= 10; i++) {
                        System.out.println(" Asynchronous Task Thread :"
                                + Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                    contextAsynchronous.complete();
                }
            });
            pw.println("</body>");
            pw.println("</html>");
            pw.close();

        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
