package org.acme.cliapp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class GreetingCLIAppTest {

    @Test
    public void testMorningResolution() {
        GreetingsCLI cliApp = new GreetingsCLI();
        assertEquals("Morning",cliApp.resolveTimeGreeting(8,cliApp.prepareDayPhaseMap()));
    }

    @Test
    public void testEveningResolution() {
        GreetingsCLI cliApp = new GreetingsCLI();
        assertEquals("Evening",cliApp.resolveTimeGreeting(18,cliApp.prepareDayPhaseMap()));
    }

    @Test
    public void testNoonResolution() {
        GreetingsCLI cliApp = new GreetingsCLI();
        assertEquals("Noon",cliApp.resolveTimeGreeting(12,cliApp.prepareDayPhaseMap()));
    }

}