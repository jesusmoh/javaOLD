/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author JOrtiz
 */
@Stateless
public class ServicioEJB1 {

    @Asynchronous
    public Future<String> getMensaje1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new AsyncResult<String>("mensaje1 lento");
    }
}
