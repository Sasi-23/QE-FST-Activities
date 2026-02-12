package demos;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity3 {

    RequestSpecification requestSpec;

    // ---------- SETUP ----------
    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();
    }

    // ---------- POST REQUEST ----------
    @Test(priority = 1)
    public void addPets() {

        String pet1 = """
                {
                  "id": 77232,
                  "name": "Riley",
                  "status": "alive"
                }
                """;

        String pet2 = """
                {
                  "id": 77233,
                  "name": "Hannel",
                  "status": "alive"
                }
                """;

        given()
            .spec(requestSpec)
            .body(pet1)
        .when()
            .post("/pet")
        .then()
            .statusCode(200)
            .body("status", Matchers.equalTo("alive"));

        given()
            .spec(requestSpec)
            .body(pet2)
        .when()
            .post("/pet")
        .then()
            .statusCode(200)
            .body("status", Matchers.equalTo("alive"));
    }

    // ---------- DATA PROVIDER ----------
    @DataProvider(name = "petData")
    public Object[][] petData() {
        return new Object[][] {
                {77232, "Riley", "alive"},
                {77233, "Hannel", "alive"}
        };
    }

    // ---------- GET REQUEST ----------
    @Test(priority = 2, dataProvider = "petData")
    public void getPetById(int id, String name, String status) {

        given()
            .spec(requestSpec)
            .pathParam("petId", id)
        .when()
            .get("/pet/{petId}")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("id", Matchers.equalTo(id))
            .body("name", Matchers.equalTo(name))
            .body("status", Matchers.equalTo(status));
    }

    // ---------- DELETE REQUEST ----------
    @Test(priority = 3, dataProvider = "petData")
    public void deletePet(int id, String name, String status) {

        given()
            .spec(requestSpec)
            .pathParam("petId", id)
        .when()
            .delete("/pet/{petId}")
        .then()
            .statusCode(200);
    }
}
