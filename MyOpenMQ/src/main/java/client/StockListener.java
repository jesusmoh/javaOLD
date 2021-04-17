/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.StringReader;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author jesus
 */
@MessageDriven(name = "stockmdb", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/stocks"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class StockListener implements MessageListener {
 

 
  @Override
  public void onMessage(Message message) {
 
    TextMessage textMessage = (TextMessage) message;
 
    try {
      System.out.println("A new stock information arrived: " + textMessage.getText());
 
      JsonReader jsonReader = Json.createReader(new StringReader(textMessage.getText()));
      JsonObject stockInformation = jsonReader.readObject();
 
     
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
 
}
