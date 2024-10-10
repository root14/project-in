package com.root14.projectin.services;

import com.root14.projectin.dto.LoginUserDto;
import com.root14.projectin.dto.RegisterUserDto;
import com.root14.projectin.entity.User;
import com.root14.projectin.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signUp(RegisterUserDto registerUserDto) {
        User user = new User().toBuilder().userName(registerUserDto.getUsername()).password(passwordEncoder.encode(registerUserDto.getPassword())).email(registerUserDto.getEmail()).build();

        if (!userRepository.existsByEmail(registerUserDto.getEmail())) {
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public User authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));

        return userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow();
    }

}
