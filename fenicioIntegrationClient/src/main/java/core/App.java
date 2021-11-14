/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.inject.Singleton;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

@Singleton
public class App {

    public static Properties propsDB = new Properties();
    
    public static void main(String[] args) throws IOException, Exception  {

        //JETTY
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);
        context.addServlet(new ServletHolder(new DefaultServlet()), "/*");
        
        //REST
        ServletHolder apiServlet = context.addServlet(ServletContainer.class, "/api/*");
        apiServlet.setInitOrder(0);
        apiServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES,"core.controller");

        //DB AND JPA
        propsDB.load(new FileInputStream(".//db.properties"));

               
        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
//           jettyServer.destroy();
        }
    }
}
