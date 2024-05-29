package com.tetrips.api.auth;

import com.tetrips.api.common.MessengerVO;
import com.tetrips.api.user.UserDTO;

public interface AuthService {
  public MessengerVO login(UserDTO param);
}
