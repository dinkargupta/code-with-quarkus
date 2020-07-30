package org.acme.services;


import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DeveloperServiceTest {

    private static final Logger logger = Logger.getLogger(DeveloperServiceTest.class);

    @Test
    public void testDeveloperAddition() {
        Map<String,Object> inputMap = new HashMap<>();
        inputMap.put("name", "Dinkar");
        inputMap.put("favouriteLanguage", "Java");
        inputMap.put("age", 42);

        String CONTENT_TYPE = "application/json";

        String EXPECTED_JSON = new JSONObject(inputMap).toString();
        logger.info("Expected JSON is: " + EXPECTED_JSON);

        given().contentType(CONTENT_TYPE).body(inputMap)
        .when().post("/developer/post")
        .then().statusCode(200);

        given()
        .when().get("/developer/get")
        .then().statusCode(200).body(is("["+EXPECTED_JSON+"]"));
    }
}
