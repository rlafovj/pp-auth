package com.jhs.api.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "GENDER", nullable = true)
  private boolean gender;

  @Column(name = "BIIRTH_DATE", nullable = true)
  private String birthDate;

  @Builder(builderMethodName = "builder")
  public User(Long id, String email, String password, boolean gender, String birthDate){
    this.id = id;
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.birthDate = birthDate;
  }
}
