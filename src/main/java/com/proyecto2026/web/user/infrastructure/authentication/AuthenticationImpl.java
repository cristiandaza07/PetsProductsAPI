package com.proyecto2026.web.user.infrastructure.authentication;

import com.proyecto2026.web.common.infrastructure.service.JwtService;
import com.proyecto2026.web.user.domain.port.AuthenticationPort;
import com.proyecto2026.web.user.infrastructure.database.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationImpl implements AuthenticationPort {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String authenticate(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
        UserEntity entity = (UserEntity) authentication.getPrincipal();

        return jwtService.generateToken(entity);

    }
}
