package com.proyecto2026.web.user.application.command.register;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserResponse {
    private String token;
}
