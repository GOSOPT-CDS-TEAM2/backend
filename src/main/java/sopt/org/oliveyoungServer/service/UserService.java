package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.domain.User;
import sopt.org.oliveyoungServer.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String findUser(Long id){
        User user = userRepository.findById(id).orElse(null);
        return user.getName();
    }
}
