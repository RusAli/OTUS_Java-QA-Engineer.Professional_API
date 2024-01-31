package dao;

import com.github.javafaker.Faker;
import dto.UserDto;

public class UserDao {

  public static UserDto createRandomUser() {

    Faker faker = new Faker();
    return UserDto.builder()
            .id(faker.number().randomDigitNotZero())
            .username(faker.name().username())
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .email(faker.bothify("????##@gmail.com"))
            .password(faker.number().digits(5))
            .phone(faker.phoneNumber().cellPhone())
            .userStatus(faker.number().numberBetween(1, 5))
            .build();
  }

}
