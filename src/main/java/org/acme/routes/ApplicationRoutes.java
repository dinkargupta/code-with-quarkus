package org.acme.routes;

import io.quarkus.vertx.http.runtime.filters.Filters;
import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationRoutes {
    public void Routes(@Observes Router router) {
        router.get("/ok").handler(rc -> rc.response().end("OK from Route"));
    }

    @Route(path="/declarativeOK", methods = HttpMethod.GET)
    public void declarativeRoutes(RoutingContext routingContext) {
        String name = routingContext.request().getParam("name");
        if (name == null) {
            name = "world";
        }
        routingContext.response().end("OK "+name + " you have been routed!");
    }

    public void filters(@Observes Filters filters) {
        filters.register(rc -> {
            rc.response().putHeader("V-Header", "Header Added by Vert.X Filter");
            rc.next();
        }, 10);
    }

    /*
        Alternative impl. of filters using RouteFilters.
        Question: which is applicable and suitable in which condition
    */
/*
    @RouteFilter(100)
    public void routeFilters(RoutingContext routingContext) {
        routingContext.response().putHeader("V-Header", "Header Added by Vert.X Filter");
        routingContext.next();
    }
*/
}
