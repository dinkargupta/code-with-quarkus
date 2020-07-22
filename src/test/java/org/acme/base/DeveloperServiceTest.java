package org.acme.base;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DeveloperServiceTest {
    
    @Test
    public void testDeveloperEndpoint() {


        Map<String,Object> input = new HashMap<>();
		input.put("id", 1);
        input.put("name", "Ada");
        
        String CONTENT_TYPE = "application/json";
        // @TODO improve this Json creation.. find a better way
        char quote='"';
        String EXPECTED_JSON = "{"+quote+"id"+quote+":1,"+quote+"name"+quote+":"+quote+"Ada"+quote+"}";
        System.out.println("Expected JSON is " + EXPECTED_JSON);

        given()
          .contentType(CONTENT_TYPE)
          .body(input)
          .when().post("/developer")
          .then()
            .statusCode(201)
            .body(is(EXPECTED_JSON));

    }

    @Test
    public void testDeveloperGrantsEndpoint() {

        given()
                .when().get("/developer/grants")
                .then()
                .statusCode(200)
                .body(is("[Read, Write, Update, Delete]"));

    }

    @Test
    public void testDevModeEndpoint() {

        given()
                .when().get("/developer/devmode")
                .then()
                .statusCode(200)
                .body(is("true"));

    }

}