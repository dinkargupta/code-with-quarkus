package org.acme.services;

import org.acme.model.Food;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Set;

@Path("/v3/products")
@RegisterRestClient
public interface FoodService {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Set<Food> getById(@PathParam("id") Integer id);
}
