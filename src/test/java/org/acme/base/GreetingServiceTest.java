package org.acme.base;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingServiceTest {

    @Test
    public void testHelloEndpoint() {
        String EXPECTED_URI = "http://localhost:8081/hello";
        String EXPECTED_ORDER = "desc";
        String EXPECTED_AUTH = "DINKAR";
        given()
          .when().header("authorization", "DINKAR", "").get("/hello?order=desc")
          .then()
             .statusCode(200)
             .body(is("URI: " + EXPECTED_URI + " - Order " + EXPECTED_ORDER + " - Authorization: " + EXPECTED_AUTH));
    }

    @Test
    public void testConfiguredHelloEndpoint() {
        String EXPECTED_RESPONSE = "I am Alive !";
        given()
                .when().get("http://localhost:8081/hello/live")
                .then()
                .statusCode(200)
                .body(is(EXPECTED_RESPONSE));
    }
}