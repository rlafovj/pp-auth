package com.tetrips.api.user;

import com.tetrips.api.common.MessengerVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<MessengerVO> signup(@RequestBody UserDTO param) {
        log.info("signup: {}", param);
        return ResponseEntity.ok(userService.signup(param));
    }

    @PostMapping("/login")
    public ResponseEntity<MessengerVO> login(@RequestBody UserDTO param) {
        log.info("login: {}", param);
        return ResponseEntity.ok(userService.login(param));
    }

    @GetMapping("/logout")
    public ResponseEntity<MessengerVO> logout(@RequestBody UserDTO param) {
        log.info("logout: {}", param);
        return ResponseEntity.ok(userService.logout(param));
    }

}
