package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "service-client-api")
public interface ServiceClient {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    String info();
}
