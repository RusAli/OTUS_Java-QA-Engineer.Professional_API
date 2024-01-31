package assertions;

import dto.EntityDto;
import dto.UserDto;
import org.assertj.core.api.SoftAssertions;

public class CustomAssert {

  public SoftAssertions soft;

  public void checkUserAssert(EntityDto entityDto, Integer code, String type) {

    soft = new SoftAssertions();

    soft.assertThat(entityDto.getCode())
            .as("Code does not equal to %s", code).isEqualTo(code);
    soft.assertThat(entityDto.getType())
            .as("Type does not equal to %s", type).isEqualTo(type);
    soft.assertThat(entityDto.getMessage())
            .as("Message is blank").isNotBlank();
    soft.assertAll();
  }

  public void checkUserAssert(EntityDto entityDto, Integer code, String type, String message) {

    soft = new SoftAssertions();

    soft.assertThat(entityDto.getCode())
            .as("Code does not equal to %s", code).isEqualTo(code);
    soft.assertThat(entityDto.getType())
            .as("Type does not equal to %s", type).isEqualTo(type);
    soft.assertThat(entityDto.getMessage())
            .as("Message does not contain %s").contains(message);
    soft.assertAll();
  }

  public void checkUserInfo(UserDto actual, UserDto expected) {

    soft = new SoftAssertions();

    soft.assertThat(actual.getUsername())
            .as("Username does not equal to %s", expected.getUsername()).isEqualTo(expected.getUsername());
    soft.assertThat(actual.getFirstName())
            .as("Firstname does not equal to %s", expected.getFirstName()).isEqualTo(expected.getFirstName());
    soft.assertThat(actual.getLastName())
            .as("Lastname does not equal to %s", expected.getLastName()).isEqualTo(expected.getLastName());
    soft.assertThat(actual.getEmail())
            .as("Email does not equal to %s", expected.getEmail()).isEqualTo(expected.getEmail());
    soft.assertThat(actual.getPassword())
            .as("Password does not equal to %s", expected.getPassword()).isEqualTo(expected.getPassword());
    soft.assertThat(actual.getPhone())
            .as("Phone does not equal to %s", expected.getPhone()).isEqualTo(expected.getPhone());
    soft.assertThat(actual.getUserStatus())
            .as("UserStatus does not equal to %s", expected.getUserStatus()).isEqualTo(expected.getUserStatus());

    soft.assertAll();
  }
}

