package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
class RegistrationResourceTest {

    @Inject
    RegistrationService registrationService;

    @Test
    void testRegistration() {
        var regIvan = new RegistrationDTO("Ivan", "Sidorov", "inan@mail.org", false);
        given()
                .when()
                .body(regIvan)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/registration")
                .then()
                .statusCode(204);
    }

    @Test
    void testGetRegistartionList() {
        registrationService.register("Ivan", "Petrov", "ivanpetrov@gmail.tt");

        given()
                .accept(MediaType.APPLICATION_JSON)
                .when().get("registration")
                .then().statusCode(200)
                .body("name", hasItem("Ivan"))
                .body("surname", hasItem("Petrov"))
                .body("email", hasItem("ivanpetrov@gmail.tt"));
    }
}