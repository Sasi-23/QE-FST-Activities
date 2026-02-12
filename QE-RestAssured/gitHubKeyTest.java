package demos;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class gitHubKeyTest {

    // ---------- Global Variables ----------
    RequestSpecification requestSpec;

    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOMONjSCOAwjNiVYBZrNeUKPqZE0UN4eraZnUS8S91td sasisadineni1@gmail.com"; // Replace with real key
    int keyId;

    // ---------- Setup ----------
   @BeforeClass
public void setup() {

    requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://api.github.com")
            .setContentType(ContentType.JSON)
            .addHeader("Authorization", "token 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")
            .build();
}

    // ---------- POST: Add SSH Key ----------
    @Test(priority = 1)
    public void addSSHKey() {

        String requestBody = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                RestAssured
                        .given()
                        .spec(requestSpec)
                        .body(requestBody)
                        .when()
                        .post("/user/keys");

        response.then().statusCode(201);

        keyId = response.jsonPath().getInt("id");

        Reporter.log("SSH Key created with ID: " + keyId, true);

        Assert.assertTrue(keyId > 0, "Key ID should be greater than 0");
    }

    // ---------- GET: Fetch SSH Key ----------
    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response =
                RestAssured
                        .given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                        .when()
                        .get("/user/keys/{keyId}");

        Reporter.log("GET Response:\n" + response.prettyPrint(), true);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "TestAPIKey");
    }

    // ---------- DELETE: Remove SSH Key ----------
    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {

        Response response =
                RestAssured
                        .given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                        .when()
                        .delete("/user/keys/{keyId}");

        Reporter.log("DELETE Response Status: " + response.getStatusCode(), true);

        Assert.assertEquals(response.getStatusCode(), 204);
    }
}

