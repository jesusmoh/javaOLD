/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.publisher.producer;

import javax.jms.JMSException;

/**
 *
 * @author jesus
 */
public class OnBoardNewCustomerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ActiveMQMessageProducer msgQueueSender = new ActiveMQMessageProducer("tcp://localhost:61616", "admin", "admin");
        try {
            msgQueueSender.setup(false, true, "VirtualTopic.Customer.Topic");
            msgQueueSender.sendMessage("-- NEW CUSTOMER -- MYID --"+ Math.random()+"--");
        } catch (JMSException e) {
        }
    }
    
}
