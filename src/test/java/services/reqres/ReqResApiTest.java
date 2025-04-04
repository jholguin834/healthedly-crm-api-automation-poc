package services.reqres;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReqResApiTest {

    @Test(groups = {"regression"})
    public void shouldGetSingleUser_SCRUM_T6() {
        var response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .when().get();

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("data.id"), 2);
        assertEquals(response.jsonPath().getString("data.first_name"), "Janet");
    }

    @Test
    public void shouldGetPaginatedUsers_SCRUM_T7() {
        var response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .queryParam("page", 2)
                .when().get();

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("page"), 2);
        assertTrue(response.jsonPath().getList("data").size() > 0);
    }

    @Test
    public void shouldCreateUser_SCRUM_T8() {
        String payload = """
        {
          "name": "Andrés",
          "job": "QA Engineer"
        }
    """;

        var response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .contentType("application/json")
                .body(payload)
                .when().post();

        assertEquals(response.statusCode(), 201);
        assertEquals(response.jsonPath().getString("name"), "Andrés");
        assertEquals(response.jsonPath().getString("job"), "QA Engineer");
        assertNotNull(response.jsonPath().getString("id"));
    }

    @Test
    public void shouldUpdateUser_SCRUM_T9() {
        String payload = """
        {
          "name": "Andrés",
          "job": "Automation Architect"
        }
    """;

        var response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .contentType("application/json")
                .body(payload)
                .when().put();

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getString("job"), "Automation Architect");
    }

    @Test
    public void shouldDeleteUser_SCRUM_T10() {
        var response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .when().delete();

        assertEquals(response.statusCode(), 204);
    }

    @Test
    public void shouldReturn404ForNonExistingResource_SCRUM_T11() {
        var response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/unknown/23")
                .when().get();

        assertEquals(response.statusCode(), 404);
    }

    @Test
    public void shouldGetDelayedResponse_SCRUM_T12() {
        var start = System.currentTimeMillis();

        var response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .queryParam("delay", 3)
                .when().get();

        var elapsed = System.currentTimeMillis() - start;

        assertEquals(response.statusCode(), 200);
        assertTrue(elapsed >= 3000);
    }
}
