package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("/")
public class Main {

    @ConfigProperty(name = "app.name")
    String appName;


    @Inject
    @RestClient
    ServiceClient client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {
        return appName;
    }

    @GET
    @Path("/call")
    @Produces(MediaType.TEXT_PLAIN)
    public String call() {
        return appName +" call " +client.info();
    }
}
