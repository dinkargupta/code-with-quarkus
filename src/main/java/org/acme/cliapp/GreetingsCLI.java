package org.acme.cliapp;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

public class GreetingsCLI implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Hello from CLI");
        Quarkus.waitForExit();
        return 0;
    }
}
