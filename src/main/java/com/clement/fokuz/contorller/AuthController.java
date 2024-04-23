package com.clement.fokuz.contorller;


import com.clement.fokuz.dto.SignupResponseDto;
import com.clement.fokuz.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public record AuthController(UserService userService) {


    @PostMapping("/signup")
    public SignupResponseDto signup() {
        return null;
    }
}
