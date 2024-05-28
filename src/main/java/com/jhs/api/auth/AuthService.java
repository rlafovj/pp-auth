package com.jhs.api.auth;

import com.jhs.api.common.MessengerVO;
import com.jhs.api.user.UserDTO;

public interface AuthService {
  public MessengerVO login(UserDTO param);
}
