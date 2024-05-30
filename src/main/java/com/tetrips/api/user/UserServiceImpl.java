package com.tetrips.api.user;

import com.tetrips.api.common.JwtProvider;
import com.tetrips.api.common.MessengerVO;
import com.tetrips.api.token.TokenRepository;
import com.tetrips.api.token.Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtProvider jwtProvider;

    @Override
    public MessengerVO login(UserDTO param) {
//        return Stream.of(param)
//                .map(i -> userRepository.findUserByEmail(i.getEmail()).orElseGet(() -> User.builder().build()))
//                .filter(i -> i.getId() != null)
//                .filter(i -> i.getPassword().equals(param.getPassword()))
//                .map(i -> deleteToken(i))
//                .peek(i -> i.setToken(tokenRepository.save(Token.builder()
//                                .userId(i)
//                                .expDate(jwtProvider.getExpiration())
//                                .refreshToken(jwtProvider.createRefreshToken(UserDTO.builder()
//                                                .email(i.getEmail())
//                                                .id(i.getId())
//                                                .build()))
//                                .build())))
//                .map(i -> userRepository.save(i))
//                .map(i -> MessengerVO.builder()
//                        .message("SUCCESS")
//                        .refreshToken(i.getToken().getRefreshToken())
//                        .accessToken(jwtProvider.createAccessToken(UserDTO.builder()
//                                .email(i.getEmail())
//                                .id(i.getId())
//                        .build()))
//                        .build())
//                .findFirst()
//                .orElseGet(() -> MessengerVO.builder()
//                        .message("FAIL")
//                        .build());
        User user = userRepository.findUserByEmail(param.getEmail()).orElseGet(() -> User.builder().build());
        boolean flag = user.getPassword().equals(param.getPassword());

        String accessToken = jwtProvider.createAccessToken(entityToDTO(user));
        String refreshToken = jwtProvider.createRefreshToken(entityToDTO(user));

        jwtProvider.printPayload(accessToken);
        jwtProvider.printPayload(refreshToken);

        return MessengerVO.builder()
                .message(flag ? "SUCCESS" : "FAIL")
                .accessToken(flag ? accessToken : null)
                .refreshToken(flag ? refreshToken : null)
                .build();
    }

    @Override
    public MessengerVO logout(UserDTO param) {
        return null;
    }

    @Override
    public User deleteToken(User user) {
        return Stream.of(user)
                .filter(i -> i.getToken() != null)
                .peek(i -> tokenRepository.deleteById(i.getToken().getId()))
                .peek(i -> i.setToken(null))
                .map(i -> userRepository.save(i))
                .findFirst()
                .get();
    }
}
