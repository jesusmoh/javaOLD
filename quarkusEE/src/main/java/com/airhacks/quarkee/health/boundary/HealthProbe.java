package com.airhacks.quarkee.health.boundary;

import javax.enterprise.context.ApplicationScoped;


import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@ApplicationScoped
public class HealthProbe implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.
        builder().
        name("quarkee").
        up().
        build();
    }

    
}