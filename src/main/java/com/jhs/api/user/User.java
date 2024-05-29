package com.jhs.api.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class User {
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "NICKNAME")
  private String nickname;

  @Column(name = "GENDER", nullable = true)
  private boolean gender;

  @Column(name = "BIRTH_DATE", nullable = true)
  private String birthDate;

  @Builder(builderMethodName = "builder")
  public User(Long id, String email, String password, String nickname, boolean gender, String birthDate){
    this.id = id;
    this.email = email;
    this.password = password;
    this.nickname = nickname;
    this.gender = gender;
    this.birthDate = birthDate;
  }
}
