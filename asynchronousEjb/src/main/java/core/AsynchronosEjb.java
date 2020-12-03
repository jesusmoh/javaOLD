/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author JOrtiz
 */
@Stateless
public class AsynchronosEjb implements AsynchronosEjbLocal
{

    @Asynchronous
    @Override
    public void slowfuntion() {

        try {
            System.out.println("------------ start ------------");
            Thread.sleep(10000);
            System.out.println("------------ end ------------");
        } catch (InterruptedException e) 
        {
           System.out.println("Upss" + e.getMessage()); 
        }
   

    }
}
