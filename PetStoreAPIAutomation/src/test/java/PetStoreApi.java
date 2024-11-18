import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class PetStoreApi {

    @Test
    public void createUser(){

        String payLoad="{\n" +
                "  \"id\": 1234,\n" +
                "  \"username\": \"alarcin2\",\n" +
                "  \"firstName\": \"sevda\",\n" +
                "  \"lastName\": \"yılmaz\",\n" +
                "  \"email\": \"sevdyilmz@gmail.com\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"phone\": \"123456789\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user").then().statusCode(200);


    }
    @Test
    public void getUserInfo(){

        RestAssured.get("https://petstore.swagger.io/v2/user/alarcin1");

    }

    @Test
    public void updateUserInfo(){

        String payLoad= "{\n" +
                "  \"id\": 12345,\n" +
                "  \"username\": \"alarcin1\",\n" +
                "  \"firstName\": \"sevda\",\n" +
                "  \"lastName\": \"yılmaz\",\n" +
                "  \"email\": \"sevdyilmz@gmail.com\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"phone\": \"123456789\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/alarcin").then().statusCode(200);

    }

    @Test
    public void deleteUser(){


        RestAssured.given().contentType(ContentType.JSON).when().delete("https://petstore.swagger.io/v2/user/alarcin1").then().statusCode(200);


    }

    @Test
    public void loginUser(){

        String payLoad= "{\n" +
                "  \"username\": \"alarcin1\",\n" +
                "  \"password\": \"123456\",\n" +
                "}";

        RestAssured.given().queryParam(payLoad).contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login").then().statusCode(200);

    }
    @Test
    public void logoutUser(){


        RestAssured.get("https://petstore.swagger.io/v2/user/logout");


    }
}
