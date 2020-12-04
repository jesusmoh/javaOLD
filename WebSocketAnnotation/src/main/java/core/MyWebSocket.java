/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author JOrtiz
 */
@ServerEndpoint("/square")
public class MyWebSocket {
    
    @OnMessage
    public String square(String value)
    {
        return " Squared value ("+Double.parseDouble(value)*Double.parseDouble(value)+") ";
    }
}
