package routes;

import static io.restassured.RestAssured.given;
import static routes.EndPoints.CREATE_USER;

import dto.UserDto;
import io.restassured.response.Response;

public class UserRequest {

  public Response createUser(UserDto userDto) {
    return given().body(userDto).post(CREATE_USER);
  }
}
