package com.clement.fokuz.service;

import com.clement.fokuz.dto.SignupRequestDto;
import com.clement.fokuz.dto.SignupResponseDto;
import com.clement.fokuz.exception.UserEmailExistException;
import com.clement.fokuz.model.Role;
import com.clement.fokuz.model.User;
import com.clement.fokuz.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignupResponseDto signup(SignupRequestDto request) {

        Optional<User> newUser = userRepository.findByEmail(request.getEmail());

        if (newUser.isPresent()) {
            throw new UserEmailExistException("Email Already exist");
        }

        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userName(request.getUsername())
                .roles(Role.USER)
                .build();


        userRepository.save(user);
        return SignupResponseDto.builder()
                .userName(user.getUserName())
                .bio(user.getBio())
                .email(user.getEmail())
                .isVerified(user.isVerified())
                .roles(user.getRoles())
                .build();
    }
}
