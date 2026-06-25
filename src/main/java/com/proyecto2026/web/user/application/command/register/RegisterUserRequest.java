package com.proyecto2026.web.user.application.command.register;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.Data;

@Data
public class RegisterUserRequest implements Request<RegisterUserResponse> {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
