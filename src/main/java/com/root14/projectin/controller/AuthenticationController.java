package com.root14.projectin.controller;

import com.root14.projectin.dto.LoginResponse;
import com.root14.projectin.dto.LoginUserDto;
import com.root14.projectin.dto.RegisterUserDto;
import com.root14.projectin.entity.User;
import com.root14.projectin.services.AuthenticationService;
import com.root14.projectin.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Controller
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) throws Exception {

        User registerUser = authenticationService.signUp(registerUserDto);
        if (registerUser != null) {
            return ResponseEntity.ok(registerUser);
        } else {
            return ResponseEntity.badRequest().body(new User());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String token = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse().toBuilder().token(token).expiresIn(jwtService.getExpirationTime()).build();

        return ResponseEntity.ok(loginResponse);
    }


}
