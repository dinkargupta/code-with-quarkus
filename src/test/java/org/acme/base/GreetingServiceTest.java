package org.acme.base;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingServiceTest {

    // this should pick up ON as TRUE and OFF and FALSE for Boolean property
    @ConfigProperty(name="staging.quarkus.http.port")
    long stagingPort;

    @Test
    public void testHelloEndpoint() {
        String EXPECTED_URI = "http://localhost:"+ stagingPort +"/hello";
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
                .when().get("http://localhost:"+stagingPort+"/hello/live")
                .then()
                .statusCode(200)
                .body(is(EXPECTED_RESPONSE));
    }
}