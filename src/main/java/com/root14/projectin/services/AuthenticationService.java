package com.root14.projectin.services;

import com.root14.projectin.dto.LoginUserDto;
import com.root14.projectin.dto.RegisterUserDto;
import com.root14.projectin.entity.User;
import com.root14.projectin.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    public User signUp(RegisterUserDto registerUserDto) throws Exception {
        User user = new User().toBuilder()
                .userName(registerUserDto.getUsername())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .email(registerUserDto.getEmail())
                .targetExpenditure("").build();


        if (!userRepository.existsByEmail(registerUserDto.getEmail()) && !userRepository.existsByUserName(registerUserDto.getUsername())) {
            return userRepository.save(user);
        } else {
            throw new Exception("credential already exist");
        }
    }

    public User authenticate(LoginUserDto loginUserDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getUserName(), loginUserDto.getPassword()));

        return (User) authentication.getPrincipal();
        //return userRepository.findByEmail(loginUserDto.getUserName()).orElseThrow();
    }

}
