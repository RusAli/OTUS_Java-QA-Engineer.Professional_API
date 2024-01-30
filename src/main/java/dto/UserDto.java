package dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

  private Integer id;

  private String username;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private String phone;

  private Integer userStatus;
}
