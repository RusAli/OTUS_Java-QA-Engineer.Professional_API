package steps;

import dto.EntityDto;
import dto.UserDto;
import org.apache.http.HttpStatus;
import routes.UserRequest;

public class UserSteps {

  protected static UserRequest userRequest = new UserRequest();

  public static EntityDto createUserWithDto(UserDto userDto) {

    return userRequest.createUserRequest(userDto)
            .then().statusCode(HttpStatus.SC_OK)
            .extract().as(EntityDto.class);

  }

  public static UserDto getUserDtoByName(String userName) {

    return userRequest.getUserByNameRequest(userName)
            .then().statusCode(HttpStatus.SC_OK)
            .extract().as(UserDto.class);
  }

  public static EntityDto getUserEntityByName(String name) {

    return userRequest.getUserByNameRequest("invalidName")
            .then().statusCode(HttpStatus.SC_NOT_FOUND)
            .extract().as(EntityDto.class);
  }

  public static EntityDto loginUser(String name, String password) {

    return userRequest.loginUserRequest(name, password)
            .then().statusCode(HttpStatus.SC_OK)
            .extract().as(EntityDto.class);
  }

  public static EntityDto loginOut() {

    return userRequest.logOutUserRequest()
            .then().statusCode(HttpStatus.SC_OK).extract().as(EntityDto.class);
  }
}
