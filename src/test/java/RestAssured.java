import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by USER on 05.11.2016.
 */
public class RestAssured {
    private final String URL = "http://jsonplaceholder.typicode.com";
    private final String CONTENT_TYPE = "application/json";

    @Test
    public void getPost1() {
        given().contentType(CONTENT_TYPE)
                .when()
                .get(URL + "/posts/1")
                .then()
                .body(containsString("userId"))
                .body(containsString("id"))
                .body(containsString("title"))
                .body(containsString("body"))
                .statusCode(200);
    }

    @Test
    public void postPosts() {
        given().contentType(CONTENT_TYPE)
                .when()
                .post(URL + "/posts")
                .then()
                .body(containsString("id"))
                .statusCode(201);
    }

    @Test
    public void putPosts1() {
        given().contentType(CONTENT_TYPE)
                .when()
                .put(URL + "/posts/1")
                .then()
                .body(containsString("id"))
                .statusCode(200);
    }

    @Test
    public void deletePosts1() {
        given().contentType("application/json")
                .when()
                .delete(URL + "/posts/1")
                .then()
                .body(containsString(""))
                .statusCode(200);
    }

    @Test
    public void incorrect() {
        given().contentType("application/json")
                .when()
                .delete(URL + "/posts/fail")
                .then()
                .body(containsString(""))
                .statusCode(404);
    }
}
