package routes;

import static io.restassured.RestAssured.given;
import static routes.EndPoints.*;

import dto.UserDto;
import io.restassured.response.Response;

public class UserRequest {

  public Response createUserRequest(UserDto userDto) {
    return given().body(userDto).post(CREATE_USER);
  }

  public Response loginUserRequest(String name, String password) {
    return given()
            .queryParam("username", name)
            .queryParam("password", password)
            .get(USER_LOGIN);
  }

  public Response logOutUserRequest() {
    return given().get(USER_LOGOUT);
  }

  public Response getUserByNameRequest(String name) {
    return given().get(GET_USER_BY_NAME, name);
  }

  public Response deleteUserByNameRequest(String name) {
    return given().delete(GET_USER_BY_NAME, name);
  }
}
