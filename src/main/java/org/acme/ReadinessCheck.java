package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class ReadinessCheck implements HealthCheck {

    @ConfigProperty(name = "enabled.readiness")
    boolean enabledReadiness;

    @ConfigProperty(name = "app.name")
    String appName;

    @Override
    public HealthCheckResponse call() {
        if (enabledReadiness) {
            return HealthCheckResponse.up(appName);
        }
        return HealthCheckResponse.down(appName);
    }
}
