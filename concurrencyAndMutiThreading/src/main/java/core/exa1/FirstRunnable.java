/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.exa1;

/**
 *
 * @author jesus
 */
public class FirstRunnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Runnable runnable =() -> {
            System.out.println("I'm running in "+ Thread.currentThread().getName());
        };
        
        Thread t= new Thread(runnable);
        t.setName("My thread");
        t.start();
                
    }
    
}
