package com.tetrips.api.user;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQueryDSL {
  List<UserDTO> findUserByEmail(String email);
  boolean existsByEmail(String email);
}
