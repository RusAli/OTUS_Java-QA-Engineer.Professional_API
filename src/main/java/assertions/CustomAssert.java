package assertions;

import dto.EntityDto;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;

public class CustomAssert {

  public SoftAssertions soft;

  public void checkCreateUserAssert(EntityDto entityDto) {

    soft = new SoftAssertions();

    soft.assertThat(entityDto.getCode())
            .as("Code does not equal to %s", HttpStatus.SC_OK).isEqualTo(HttpStatus.SC_OK);
    soft.assertThat(entityDto.getType())
            .as("Type does not equal to unknown").isEqualTo("unknown");
    soft.assertThat(entityDto.getMessage())
            .as("Message is blank").isNotBlank();
    soft.assertAll();
  }
}
