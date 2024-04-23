package com.clement.fokuz.dto;

import com.clement.fokuz.model.Role;
import lombok.Builder;


@Builder
public record SignupResponseDto(

        String userName,

        String email,

        Role roles,

        String bio,

        String password,

        boolean isVerified

) {
}
