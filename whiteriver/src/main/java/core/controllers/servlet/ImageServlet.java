/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controllers.servlet;

import core.App;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    @EJB
    private App app;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String filename="";
        try 
        { 
        
        filename = request.getPathInfo().substring(1);
        File file = new File(app.getImgCarpeta().getValue(), filename);
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
        Files.copy(file.toPath(), response.getOutputStream());
        
        } catch (Exception e) {
             System.out.println("No imagen para"+filename );
            }
    }
}
