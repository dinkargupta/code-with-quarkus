package org.acme.services;

import org.acme.model.Developer;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/developer")
public class DeveloperService {
    private static final List<Developer> developers = new ArrayList<>();

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDeveloper(@Valid Developer developer) {
        developers.add(developer);
        return Response.ok().build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> getDevelopers() {
        return developers;
    }
}
