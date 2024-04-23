package com.clement.fokuz.dto;

import com.clement.fokuz.constants.ValidationConstants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;

import static com.clement.fokuz.constants.ValidationConstants.*;

@Builder
@AllArgsConstructor
public class SignupRequestDto {

    @NotNull(message = USERNAME_NOT_NULL)
    private String username;

    @NotNull(message = EMAIL_NOT_NULL)
    private String email;

    @NotNull(message = PASSWORD_NOT_NULL)
    @Min(value = 8, message = PASSWORD_MIN_MSG)
    @Max(value = 32, message = PASSWORD_MAX_MSG)
    private String password;

    @NotNull(message = PASSWORD_NOT_NULL)
    @Min(value = 8, message = PASSWORD_MIN_MSG)
    @Max(value = 32, message = PASSWORD_MAX_MSG)
    private String passwordConfirm;

}
