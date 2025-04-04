package services.dummyjson;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserApiTest {

    @Test
    public void shouldLoginSuccessfully_SCRUM_T3() {
        var payload = """
        {
          "username": "kminchelle",
          "password": "0lelplR"
        }
    """;

        var response = RestAssured.given()
                .baseUri("https://dummyjson.com")
                .basePath("/auth/login")
                .contentType("application/json")
                .body(payload)
                .when().post();

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getString("username"), "kminchelle");
        assertNotNull(response.jsonPath().getString("token"));
    }

    @Test
    public void shouldGetUsersWithPagination_SCRUM_T4() {
        var response = RestAssured.given()
                .baseUri("https://dummyjson.com")
                .basePath("/users")
                .queryParam("limit", 5)
                .queryParam("skip", 0)
                .when().get();

        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getList("users").size() <= 5);
    }

}
