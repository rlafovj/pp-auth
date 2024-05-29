package com.tetrips.api.token;

import com.tetrips.api.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "TOKENS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Token {
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "REFRESH_TOKEN", nullable = false)
  private String refreshToken;

  @Column(name = "EXP_DATE", nullable = false)
  private String expDate;

  @OneToOne
  @JoinColumn(name = "USER_ID", nullable = false)
  private User userId;
}
