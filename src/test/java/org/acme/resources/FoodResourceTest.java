package org.acme.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class FoodResourceTest {
/*    @Test
    public void testFoodAPIEndpoint() {
        given()
                .when().header("Authorization","Token token=c33fd5c9717b0d9ed5bc0c7783eca884").get("/food/12823")
                .then()
                .statusCode(200);
    }*/

    @Test
    public void testFoodAPIEndpointDirect() {
        given()
                .when().accept(MediaType.APPLICATION_JSON)
                .header("Authorization","Token token=c33fd5c9717b0d9ed5bc0c7783eca884")
                .get("https://www.foodrepo.org/api/v3/products/12823")
                .then()
                .statusCode(200);
    }
}
