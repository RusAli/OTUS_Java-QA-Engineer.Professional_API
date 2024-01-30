import assertions.CustomAssert;
import dao.UserDao;
import dto.EntityDto;
import dto.UserDto;
import extentions.Extention;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import routes.UserRequest;

@ExtendWith(Extention.class)
public class UserTest {

  private UserRequest userRequest;
  private CustomAssert customAssert;

  @BeforeEach
  public void setUp() {
    userRequest = new UserRequest();
    customAssert = new CustomAssert();
  }

  @Test
  @Description("Проверка создания пользователя")
  public void shouldCreateUser() {

    UserDto userDto = UserDao.createRandomUser();
    EntityDto entityDto = userRequest.createUser(userDto)
            .then().statusCode(HttpStatus.SC_OK)
            .extract().as(EntityDto.class);

    customAssert.checkCreateUserAssert(entityDto);
  }
}
