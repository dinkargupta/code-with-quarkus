package org.acme.services;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import org.jboss.logging.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreetingsCLIAppService implements QuarkusApplication {

    private static final Logger logger = Logger.getLogger(GreetingsCLIAppService.class);

    @Override
    public int run(String... args) throws Exception {
        final int currentHour = LocalTime.now().getHour();

        final Map<List<Integer>, String> hourPhaseMap = prepareDayPhaseMap();
        final String GreetingPrefix = resolveTimeGreeting(currentHour, hourPhaseMap);

        logger.info("\n Good " + GreetingPrefix + "! Greetings from CLI. You logged in on " + LocalDate.now() + " at " + LocalTime.now().format(DateTimeFormatter.ofPattern("H:m a")));
        Quarkus.waitForExit();
        return 0;
    }

    public Map<List<Integer>, String> prepareDayPhaseMap() {
        final Map<List<Integer>,String> hourPhaseMap = new HashMap<List<Integer>,String>();
        hourPhaseMap.put(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11),"Morning");
        hourPhaseMap.put(Arrays.asList(12),"Noon");
        hourPhaseMap.put(Arrays.asList(13,14,15,16,17),"Afternoon");
        hourPhaseMap.put(Arrays.asList(18,19,20),"Evening");
        hourPhaseMap.put(Arrays.asList(21,22,23, 24),"Night");
        return hourPhaseMap;
    }

    public String resolveTimeGreeting(int currentHour, Map<List<Integer>, String> hourPhaseMap) {
        String phase = "Day";
        phase = hourPhaseMap.get(hourPhaseMap.keySet().stream().filter(n-> n.contains(currentHour)).findFirst().get());
        return phase;
    }


}
