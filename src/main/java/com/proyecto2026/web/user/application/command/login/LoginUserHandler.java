package com.proyecto2026.web.user.application.command.login;

import com.proyecto2026.web.common.application.mediator.RequestHandler;
import org.springframework.stereotype.Service;

@Service
public class LoginUserHandler implements RequestHandler<LoginUserRequest, LoginUserResponse> {
    @Override
    public LoginUserResponse handle(LoginUserRequest request) {

        return null;
    }

    @Override
    public Class<LoginUserRequest> getRequestType() {

        return LoginUserRequest.class;
    }
}
