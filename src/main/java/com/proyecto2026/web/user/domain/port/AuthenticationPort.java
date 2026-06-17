package com.proyecto2026.web.user.domain.port;

public interface AuthenticationPort {
    String authenticate(String username, String password);
}
