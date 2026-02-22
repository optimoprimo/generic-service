package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class LivenessCheck implements HealthCheck {

    @ConfigProperty(name = "enabled.liveness")
    boolean enabledLiveness;

    @Override
    public HealthCheckResponse call() {
        if (enabledLiveness) {
            return HealthCheckResponse.up("generic-service");
        }
        return HealthCheckResponse.down("generic-service");
    }
}
