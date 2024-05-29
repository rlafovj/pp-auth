package com.tetrips.api.user;

import com.tetrips.api.common.MessengerVO;

public interface UserService {
  MessengerVO login(UserDTO param);
}
