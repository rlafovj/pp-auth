package com.jhs.api.auth;

import com.jhs.api.common.MessengerVO;
import com.jhs.api.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
  @Override
  public MessengerVO login(UserDTO param) {
    return null;
  }
}
