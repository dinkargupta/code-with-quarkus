package org.acme.resources;


import org.acme.model.Food;
import org.acme.services.FoodService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Set;

@Path("/products")
public class FoodResource {
    @Inject
    @RestClient
    FoodService foodService;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Set<Food> getById(@PathParam("id") Integer id) {
        return foodService.getById(12823);
    }
}
