package com.petsproducts.user.application.command.logout;

import com.petsproducts.common.application.mediator.Request;
import lombok.Data;

@Data
public class LogoutUserRequest implements Request<Void> {
    private String token;
}
