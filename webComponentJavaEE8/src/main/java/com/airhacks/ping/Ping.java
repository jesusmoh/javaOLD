/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.ping;

import javax.json.JsonObjectBuilder;
import javax.json.bind.JsonbBuilder;

/**
 *
 * @author JOrtiz
 */
public class Ping {
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public String toJson() {
        return JsonbBuilder.create().toJson(this);
    }

    public Ping(String message) {
        this.message = message;
    }
    
    
}
