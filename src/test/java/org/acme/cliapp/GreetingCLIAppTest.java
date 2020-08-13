package org.acme.cliapp;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.services.GreetingsCLIAppService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class GreetingCLIAppTest {

    @Test
    public void testMorningResolution() {
        GreetingsCLIAppService cliApp = new GreetingsCLIAppService();
        assertEquals("Morning",cliApp.resolveTimeGreeting(8,cliApp.prepareDayPhaseMap()));
    }

    @Test
    public void testEveningResolution() {
        GreetingsCLIAppService cliApp = new GreetingsCLIAppService();
        assertEquals("Evening",cliApp.resolveTimeGreeting(18,cliApp.prepareDayPhaseMap()));
    }

    @Test
    public void testNoonResolution() {
        GreetingsCLIAppService cliApp = new GreetingsCLIAppService();
        assertEquals("Noon",cliApp.resolveTimeGreeting(12,cliApp.prepareDayPhaseMap()));
    }

}