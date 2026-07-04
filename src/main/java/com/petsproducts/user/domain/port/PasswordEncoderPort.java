package com.petsproducts.user.domain.port;

public interface PasswordEncoderPort {
    String encode(String password);
}
