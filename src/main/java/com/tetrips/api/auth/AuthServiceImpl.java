package com.tetrips.api.auth;

import com.tetrips.api.common.MessengerVO;
import com.tetrips.api.user.UserDTO;
import com.tetrips.api.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
  private final UserRepository userRepository;
  @Override
  public MessengerVO login(UserDTO param) {
    return null;
  }
}
