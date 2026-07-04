package com.petsproducts.user.application.command.login;

import com.petsproducts.common.application.mediator.Request;
import lombok.Data;

@Data
public class LoginUserRequest implements Request<LoginUserResponse> {
    private String email;
    private String password;
}
