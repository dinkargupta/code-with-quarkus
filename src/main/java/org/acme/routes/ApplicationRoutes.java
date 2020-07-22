package org.acme.routes;

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
}
