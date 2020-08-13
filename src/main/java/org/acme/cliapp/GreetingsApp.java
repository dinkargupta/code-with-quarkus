package org.acme.cliapp;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.acme.services.GreetingsCLIAppService;

@QuarkusMain
public class GreetingsApp {
    public static void main(String[] args) {
        Quarkus.run(GreetingsCLIAppService.class, args);
    }
}
