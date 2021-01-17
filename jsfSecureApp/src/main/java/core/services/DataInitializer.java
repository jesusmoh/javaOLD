/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.model.entities.User;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 *
 * @author JOrtiz
 */

@Singleton
@Stateless
@Startup
public class DataInitializer {

    @Inject
    DataSecureUserService dataService;

    @PostConstruct
    public void execute() {
        if (dataService.getAllUser().size()<=0) {
            User sally = dataService.createUser("Sally Addams", "saddams", "saddams", "admin");
            User tom = dataService.createUser("Tom Matthews", "tmatthews", "tmatthews", "user");

            dataService.createQuality("Wonderful", sally);
            dataService.createQuality("Team Player", sally);
            dataService.createQuality("Good Judgement", sally);
            dataService.createQuality("Good Leader", sally);

            dataService.createQuality("Dilligent", tom);
            dataService.createQuality("Responsible", tom);
            dataService.createQuality("Cares for his teammates", tom);
        }
    }
}
