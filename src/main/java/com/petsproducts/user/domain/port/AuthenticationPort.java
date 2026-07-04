package com.petsproducts.user.domain.port;

public interface AuthenticationPort {
    String authenticate(String username, String password);
}
