package org.acme.routes;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ApplicationRoutesTest {

    @Test
    public void testRouteEndpoint() {
        String EXPECTED_RESPONSE = "OK from Route";
        given()
                .when().get("/ok")
                .then()
                .statusCode(200)
                .body(is(EXPECTED_RESPONSE));
    }

    @Test
    public void testDeclarativeRouteEndpoint() {
        String EXPECTED_RESPONSE = "OK Dinkar you have been routed!";
        given()
                .when()
                .get("/declarativeOK?name=Dinkar")
                .then()
                .statusCode(200)
                .body(is(EXPECTED_RESPONSE));
    }

    @Test
    public void testFilters() {
        String EXPECTED_RESPONSE = "OK Dinkar you have been routed!";
        given()
                .when()
                .get("/declarativeOK?name=Dinkar")
                .then()
                .statusCode(200)
                .header("V-Header","Header Added by Vert.X Filter")
                .body(is(EXPECTED_RESPONSE));
    }
}
