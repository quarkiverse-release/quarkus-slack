package io.quarkiverse.slack.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class SlackResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/slack")
                .then()
                .statusCode(200)
                .body(is("Hello slack"));
    }
}
