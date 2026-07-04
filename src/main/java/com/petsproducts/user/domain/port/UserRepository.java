package com.petsproducts.user.domain.port;

import com.petsproducts.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    User save(User user);
}
