package com.clement.fokuz.service;

import com.clement.fokuz.dto.SignupRequestDto;
import com.clement.fokuz.dto.SignupResponseDto;

public interface UserService {
    SignupResponseDto signup(SignupRequestDto request);
}
