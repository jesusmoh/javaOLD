/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import controllers.service.websocket.PushBean;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.persistence.PrePersist;

/**
 *
 * @author jesus
 */
@Typed
public final class EventObserver {

    @Inject
    private PushBean pushP;
    
    private EventObserver() {}

    @PrePersist
    public void onEntityChange(@Observes WebMaCiudades event) {
        System.out.println("PRUEBA DE EVENTO "+event.getDescripcion());
        pushP.entitiesAction();
    }
}
