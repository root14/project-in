package com.root14.projectin.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String username;
    private String password;
    private String email;
    private String targetExpenditure;
}
