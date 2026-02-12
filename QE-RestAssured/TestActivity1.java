package demos;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestActivity1 {

    static long petId;
    static String petName = "Charlie";

    @BeforeClass
    public void setup() {
        baseURI = "https://petstore.swagger.io/v2";
    }

    // ---------------- POST ----------------
    @Test(priority = 1)
    public void createPet() {

        petId = System.currentTimeMillis(); // unique ID

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", petId);
        requestBody.put("name", petName);
        requestBody.put("status", "available");

        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(requestBody)
            .log().all()
        .when()
            .post("/pet")
        .then()
            .statusCode(200)
            .log().all()
            .body("name", equalTo(petName))
            .body("status", equalTo("available"));

        System.out.println("POST successful, Pet ID: " + petId);
    }

    // ---------------- GET ----------------
    @Test(priority = 2, dependsOnMethods = "createPet")
    public void getPet() {

        Response response =
            given()
                .accept(ContentType.JSON)
                .log().all()
            .when()
                .get("/pet/" + petId)
            .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        // SAFE assertions (Petstore-friendly)
        String name = response.jsonPath().getString("name");
        String status = response.jsonPath().getString("status");

        org.testng.Assert.assertEquals(name, petName);
        org.testng.Assert.assertEquals(status, "available");

        System.out.println("GET successful");
    }

    // ---------------- DELETE ----------------
    @Test(priority = 3, dependsOnMethods = "getPet")
    public void deletePet() {

        given()
            .log().all()
        .when()
            .delete("/pet/" + petId)
        .then()
            .statusCode(200)
            .log().all()
            .body("message", equalTo(String.valueOf(petId)));

        System.out.println("DELETE successful");
    }
}
