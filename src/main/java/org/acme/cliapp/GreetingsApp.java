package org.acme.cliapp;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class GreetingsApp {
    public static void main(String[] args) {
        Quarkus.run(GreetingsCLI.class, args);
    }
}
