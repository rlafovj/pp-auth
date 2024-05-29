package com.jhs.api.user;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class UserDTO {
  private Long id;
  private String email;
  private String password;
  private String nickname;
  private boolean gender;
  private String birthDate;
  private String token;
}
