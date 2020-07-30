package org.acme.services;


import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class DeveloperServiceTest {

    private static final Logger logger = Logger.getLogger(DeveloperServiceTest.class);

    @Test
    public void testDeveloperAddition() {
        Map<String, Object> inputMap = getInputMap("Dinkar","Java", 42);

        String CONTENT_TYPE = "application/json";

        String EXPECTED_JSON = new JSONObject(inputMap).toString();
        logger.info("Expected JSON is: " + EXPECTED_JSON);

        given().contentType(CONTENT_TYPE).body(inputMap)
        .when().post("/developer/post")
        .then().statusCode(200);
/*
        given()
        .when().get("/developer/get")
        .then().statusCode(200).body(is("["+EXPECTED_JSON+"]"));*/
    }

    @Test
    public void testNameValidationFailure() {
        Map<String, Object> inputMap = getInputMap("DG","Java", 42);
        Map<String,String> outputMap = getOutputMap("addDeveloper.developer.name","size must be between 4 and "+Integer.MAX_VALUE);
        String outputBody = "[" + new JSONObject(outputMap).toString().replace("\\","") + "]";

        String CONTENT_TYPE = "application/json";

        given().contentType(CONTENT_TYPE).body(inputMap)
                .when().post("/developer/post")
                .then().statusCode(400).body(is(outputBody));
    }

    @Test
    public void testFavouriteLangaugeValidationFailure() {
        Map<String, Object> inputMap = getInputMap("Dinkar","", 42);
        Map<String,String> outputMap = getOutputMap("addDeveloper.developer.favouriteLanguage","must not be blank");
        String outputBody = "[" + new JSONObject(outputMap).toString().replace("\\","") + "]";

        String CONTENT_TYPE = "application/json";

        given().contentType(CONTENT_TYPE).body(inputMap)
                .when().post("/developer/post")
                .then().statusCode(400).body(is(outputBody));
    }

    @Test
    public void testAgeValidationFailure() {
        Map<String, Object> inputMap = getInputMap("Dinkar","Java", 17);
        Map<String,String> outputMap = getOutputMap("addDeveloper.developer.age","must be greater than or equal to 18");
        String outputBody = "[" + new JSONObject(outputMap).toString().replace("\\","") + "]";

        String CONTENT_TYPE = "application/json";

        given().contentType(CONTENT_TYPE).body(inputMap)
                .when().post("/developer/post")
                .then().statusCode(400).body(is(outputBody));
    }

    private Map<String, String> getOutputMap(String path, String message) {
        Map<String,String> outputMap = new HashMap<>();
        outputMap.put("path", path);
        outputMap.put("message", message);
        return outputMap;
    }


    @NotNull
    private Map<String, Object> getInputMap(String name, String favouriteLanguage, int age) {
        Map<String,Object> inputMap = new HashMap<>();
        inputMap.put("name", name);
        inputMap.put("favouriteLanguage", favouriteLanguage);
        inputMap.put("age", age);
        return inputMap;
    }
}
