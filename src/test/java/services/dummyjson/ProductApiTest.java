package services.dummyjson;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductApiTest {

    @Test
    public void shouldSearchProductsByKeyword() {
        var response = RestAssured.given()
                .baseUri("https://dummyjson.com")
                .basePath("/products/search")
                .queryParam("q", "laptop")
                .when().get();

        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getList("products").size() > 0);
        assertTrue(response.asString().toLowerCase().contains("laptop"));
    }

    @Test
    public void shouldGetProductDetails() {
        var response = RestAssured.given()
                .baseUri("https://dummyjson.com")
                .basePath("/products/1")
                .when().get();

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("id"), 1);
        assertNotNull(response.jsonPath().getString("title"));
        assertNotNull(response.jsonPath().getFloat("price"));
    }


}
