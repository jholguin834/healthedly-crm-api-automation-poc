package services.reqres;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest {

//    @Test
//    public void shouldLoginWithValidCredentials() {
//        String jsonPayload = """
//          {
//            "username": "demo@example.com",
//            "password": "password"
//          }
//        """;
//
//        var response = RestAssured.given()
//                .baseUri("https://marmelab.com")
//                .basePath("/react-admin-demo/login")
//                .contentType(ContentType.JSON)
//                .body(jsonPayload)
//                .when().post();
//
//        assertEquals(response.statusCode(), 200);
//        assertNotNull(response.jsonPath().getString("token"));
//    }

    @Test(groups = {"sanity"})
    public void shouldLoginWithValidCredentials_SCRUM_T5() {
        String payload = """
      {
        "email": "eve.holt@reqres.in",
        "password": "cityslicka"
      }
    """;

        var response = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/login")
                .contentType("application/json")
                .body(payload)
                .when().post();

        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().getString("token"));
    }

}
