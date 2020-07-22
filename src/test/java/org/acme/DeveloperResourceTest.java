package org.acme;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.is;

import java.util.Map;
import java.util.HashMap;

@QuarkusTest
public class DeveloperResourceTest {
    
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
}