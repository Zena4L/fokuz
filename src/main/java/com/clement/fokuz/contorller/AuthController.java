package com.clement.fokuz.contorller;


import com.clement.fokuz.dto.SignupRequestDto;
import com.clement.fokuz.dto.SignupResponseDto;
import com.clement.fokuz.model.User;
import com.clement.fokuz.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public record AuthController(UserService userService) {


    @PostMapping("/signup")
    @Operation(summary = "Singup a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created succesfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request body",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication failed",
                    content = @Content)})
    public SignupResponseDto signup(@RequestBody SignupRequestDto request) {
        return userService.signup(request);
    }
}
