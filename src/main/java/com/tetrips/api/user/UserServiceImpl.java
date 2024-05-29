package com.tetrips.api.user;

import com.tetrips.api.common.MessengerVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public MessengerVO login(UserDTO param) {
        return Stream.of(param)
                .map(i -> userRepository.findByEmail(i.getEmail()))
                .filter(i -> i.isPresent())
                .map(i -> i.get().getPassword().equals(param.getPassword()))
                .map(i -> i ? "SUCCESS" : "FAIL")
                .map(i -> MessengerVO.builder().message(i).build())
                .findFirst()
                .get();
    }
}
