package com.jhs.api.auth;

import com.jhs.api.common.MessengerVO;
import com.jhs.api.user.UserDTO;
import com.jhs.api.user.UserRepository;
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
