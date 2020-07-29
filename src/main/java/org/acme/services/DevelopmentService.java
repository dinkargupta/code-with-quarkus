package org.acme.services;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("development")
public class DevelopmentService {
    

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        developer.persist();
        return Response.created(UriBuilder.fromResource(DevelopmentService.class).path(Long.toString(developer.getId(), 0)).build()).entity(developer).build();
    }

    @ConfigProperty(name="iam.permissions.granted")
    List<String> grantedPermissions;

    @GET
    @Path("/grants")
    @Produces(MediaType.TEXT_PLAIN)
    public String permissionsGranted() {
        return grantedPermissions.toString();
    }

    // this should pick up ON as TRUE and OFF and FALSE for Boolean property
    @ConfigProperty(name="devMode")
    Boolean devMode;

    @GET
    @Path("/devmode")
    @Produces(MediaType.TEXT_PLAIN)
    public String inDevMode() {
        return devMode ? "true" : "false";
    }

    public static class Developer {
        static long counter = 1;

        private long id;

        private String name;

        public long getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void persist() {
            this.id = counter++;
        }
    }
}