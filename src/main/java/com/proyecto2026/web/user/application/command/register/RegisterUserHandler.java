package com.proyecto2026.web.user.application.command.register;

import com.proyecto2026.web.common.application.mediator.RequestHandler;
import com.proyecto2026.web.user.domain.User;
import com.proyecto2026.web.user.domain.UserRole;
import com.proyecto2026.web.user.domain.port.AuthenticationPort;
import com.proyecto2026.web.user.domain.port.PasswordEncoderPort;
import com.proyecto2026.web.user.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserHandler implements RequestHandler<RegisterUserRequest, RegisterUserResponse> {

    private final UserRepository userRepository;
    private final PasswordEncoderPort passwordEncoderPort;
    private final AuthenticationPort authenticationPort;

    @Override
    public RegisterUserResponse handle(RegisterUserRequest request) {
        boolean existsByEmail = userRepository.existsByEmail(request.getEmail());

        if (existsByEmail) {
            throw new RuntimeException("Email already exists");
        }

        String encodedPassword = passwordEncoderPort.encode(request.getPassword());

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(encodedPassword)
                .role(UserRole.USER)
                .build();

        User saveUser = userRepository.save(user);
        String token = authenticationPort.authenticate(request.getEmail(), request.getPassword());

        return new RegisterUserResponse(token);
    }

    @Override
    public Class<RegisterUserRequest> getRequestType() {
        return RegisterUserRequest.class;
    }
}
