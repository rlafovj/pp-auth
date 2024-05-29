package com.tetrips.api.user;

import com.tetrips.api.common.MessengerVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    public MessengerVO login(UserDTO param) {
        return userService.login(param);
    }
}
