package org.acme.base;

import io.quarkus.runtime.configuration.ProfileManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class GreetingService {

    public enum Order {
        desc, asc
    }

    private static Logger logger = Logger.getLogger(GreetingService.class);
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context UriInfo uriInfo, @QueryParam("order") Order order, @NotBlank @HeaderParam("authorization") String authorization) {
        logger.info("Active profile is: " + ProfileManager.getActiveProfile());
        return String.format("URI: %s - Order %s - Authorization: %s", uriInfo.getAbsolutePath(), order, authorization);
    }

    @ConfigProperty(name = "greeting.message")
    String message;

    @GET
    @Path("/live")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig() {
        return message;
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String messgae) {

        logger.info("Create");;
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message) {
        logger.info("Update");
        return message;
    }

    @DELETE
    public void delete() {
        logger.info("Delete");
    }

    /*
     test with “curl -X LOCK http://localhost:8080/hello/1
     */
    @LOCK
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String lockResource(@PathParam("id") long id) {
        System.out.println("Locked");
        logger.info("Locked");
        return id + " locked";
    }

    @GET
    @Path("/log")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloLog() {
        logger.info("I said Hello");
        return "hello";
    }
}