package util;

import com.clement.fokuz.dto.SignupRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        SignupRequestDto requestDto = (SignupRequestDto) obj;
        return requestDto.getPassword().equals(requestDto.getPasswordConfirm());
    }
}
