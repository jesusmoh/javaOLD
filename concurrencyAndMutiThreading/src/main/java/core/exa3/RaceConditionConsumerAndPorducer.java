/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.exa3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus
 */
public class RaceConditionConsumerAndPorducer {

    private static int count = 0;
    private static int[] buffer = new int[10];
    private static Object lock = new Object();

    static class Consumer {

        public void consumer() {
            synchronized (lock) {
                if (isEmpty(buffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RaceConditionConsumerAndPorducer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                buffer[--count] = 1;
                lock.notifyAll();
            }

        }
    }

    static class Producer {

        public void produce() {
            synchronized (lock) {
                if (isFull(buffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RaceConditionConsumerAndPorducer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                buffer[++count] = 1;
                lock.notifyAll();
            }

        }
    }

    static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    public static void main(String[] args) {

        buffer = new int[50];
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable producerTask = ()
                -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing");
        };
        Runnable consumerTask = ()
                -> {
            for (int i = 0; i < 45; i++) {
                consumer.consumer();
            }
            System.out.println("Done consuming");
        };

        Thread consumerThreads = new Thread(consumerTask);
        Thread producerthreads = new Thread(producerTask);

        consumerThreads.start();
        producerthreads.start();

        try {
            consumerThreads.join();
            producerthreads.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(RaceConditionConsumerAndPorducer.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Data in the buffer is " + count);

    }

}
