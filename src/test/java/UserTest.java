import assertions.CustomAssert;
import dao.UserDao;
import dto.EntityDto;
import dto.UserDto;
import extentions.Extention;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.UserSteps;

@ExtendWith(Extention.class)
public class UserTest extends UserSteps {
  private CustomAssert customAssert;
  private UserDto userDto;


  @BeforeEach
  public void setUp() {

    customAssert = new CustomAssert();

    userDto = UserDao.createRandomUser();
  }

  @Test
  @Description("Проверка создания пользователя")
  public void shouldCreateUser() {

    EntityDto entityDto = createUserWithDto(userDto);
    customAssert.checkUserAssert(entityDto, 200, "unknown");

    UserDto createdUserDto = getUserDtoByName(userDto.getUsername());
    customAssert.checkUserInfo(userDto, createdUserDto);
  }

  @Test
  @Description("Получить информацию о несуществующем пользователе")
  public void shouldNotReturnUserInfo() {

    EntityDto entityDto = getUserEntityByName("invalidName");
    customAssert.checkUserAssert(entityDto, 1, "error", "User not found");
  }

  @Test
  @Description("Логин пользователя")
  public void shouldLoginWithCreatedUser() {

    UserDto userDto = UserDao.createRandomUser();
    EntityDto entityDto = createUserWithDto(userDto);
    EntityDto loginPayload = loginUser(userDto.getUsername(), userDto.getPassword());

    customAssert.checkUserAssert(loginPayload, 200, "unknown", "logged in user session:");
  }

  @Test
  @Description("Выход пользователя")
  public void shouldLogOutCurrentUser() {

    EntityDto logOutPayload = loginOut();
    customAssert.checkUserAssert(logOutPayload, 200, "unknown", "ok");
  }
}
