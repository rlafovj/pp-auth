package com.jhs.api.common.interceptor;

import com.jhs.api.common.JwtProvider;
import com.jhs.api.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
  private final JwtProvider jwtProvider;
  private final UserRepository userRepository;
}
