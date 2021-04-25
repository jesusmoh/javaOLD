/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.exa2;

/**
 *
 * @author jesus
 */
public class RaceCondition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        LongWrapper longWrapper= new LongWrapper(0L);
        
        Runnable runnable =() -> 
        {
            for (int i = 0; i < 1_000; i++) {
                longWrapper.incrementValue();
            }
        };
        
        Thread[] threads= new Thread[1_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i]= new Thread(runnable);
            threads[i].start();// whe execute start the  app closed the threads, if es run the threas live forever
        }
        
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();// this method is used to wait the current thread , to join a tail
        }
        
        System.out.println("Value "+longWrapper.getL());

        
        
        
        
    }
    
}
