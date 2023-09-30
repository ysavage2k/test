import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestApiTest {
    @Test
    public void getUrl(){
        String GetUrl = "https://swapi.dev/api/people";
        String basePath = "/1/";
        int statusCode = 200;
        given()
                .baseUri(GetUrl)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(statusCode)
                .body("name", equalTo("Luke Skywalker"));
    }
    @Test
    public void getUrlNegative(){
        String GetUrl = "https://swapi.dev/api/people";
        String basePath = "/1/";
        given()
                .baseUri(GetUrl)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("name", equalTo("Luke Skywalker"));
    }
}
