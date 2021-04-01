package com.codessquad.qna.service;

import com.codessquad.qna.domain.User;
import com.codessquad.qna.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String userId, String password) {
        User user = userRepository.findByUserId(userId).orElseThrow(IllegalStateException::new);
        if(!user.isMatchingPassword(password)) {
            throw new IllegalStateException();
        }

        return user;
    }


}
