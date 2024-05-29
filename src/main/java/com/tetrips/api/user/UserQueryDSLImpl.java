package com.tetrips.api.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserQueryDSLImpl implements UserQueryDSL{
  private final JPAQueryFactory factory;

  @Override
  public List<UserDTO> findUserByEmail(String email) {
    QUser qUser = QUser.user;
    return factory.select(
            new QUserDTO(
                    qUser.id,
                    qUser.email,
                    qUser.password,
                    qUser.nickname,
                    qUser.gender,
                    qUser.birthDate,
                    qUser.token
    ))
            .from(qUser)
            .where(qUser.email.eq(email))
            .fetch();
  }

  @Override
  public boolean existsByEmail(String email) {
    QUser qUser = QUser.user;
    return factory.selectFrom(QUser.user)
            .where(qUser.email.eq(email))
            .fetchFirst() != null;
  }
}
