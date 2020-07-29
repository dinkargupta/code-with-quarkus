package org.acme.services;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DevelopmentServiceTest {
    
    @Test
    public void testDeveloperEndpoint() {


        Map<String,Object> input = new HashMap<>();
		input.put("id", 1);
        input.put("name", "Ada");
        
        String CONTENT_TYPE = "application/json";
        // @TODO improve this Json creation.. find a better way
        char quote='"';
        String EXPECTED_JSON = "{"+quote+"id"+quote+":1,"+quote+"name"+quote+":"+quote+"Ada"+quote+"}";

        given()
          .contentType(CONTENT_TYPE)
          .body(input)
          .when().post("/development")
          .then()
            .statusCode(201)
            .body(is(EXPECTED_JSON));

    }

    @Test
    public void testDeveloperGrantsEndpoint() {

        given()
                .when().get("/development/grants")
                .then()
                .statusCode(200)
                .body(is("[Read, Write, Update, Delete]"));

    }

    @Test
    public void testDevModeEndpoint() {

        given()
                .when().get("/development/devmode")
                .then()
                .statusCode(200)
                .body(is("true"));

    }

}