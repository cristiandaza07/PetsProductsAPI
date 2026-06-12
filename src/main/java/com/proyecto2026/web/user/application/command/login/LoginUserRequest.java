package com.proyecto2026.web.user.application.command.login;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.Data;

@Data
public class LoginUserRequest implements Request<LoginUserResponse> {
    private String email;
    private String password;
}
