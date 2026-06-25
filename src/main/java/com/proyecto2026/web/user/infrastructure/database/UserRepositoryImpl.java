package com.proyecto2026.web.user.infrastructure.database;

import com.proyecto2026.web.user.domain.User;
import com.proyecto2026.web.user.domain.port.UserRepository;
import com.proyecto2026.web.user.infrastructure.database.entity.UserEntity;
import com.proyecto2026.web.user.infrastructure.database.mapper.UserEntityMapper;
import com.proyecto2026.web.user.infrastructure.database.repository.QueryUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final QueryUserRepository queryUserRepository;
    private final UserEntityMapper userEntityMapper;


    @Override
    public Optional<User> findByEmail(String email) {
        return queryUserRepository.findByEmail(email).map(userEntityMapper::mapToUser);
    }

    @Override
    public boolean existsByEmail(String email) {
        return queryUserRepository.findByEmail(email).isPresent();
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userEntityMapper.mapToUserEntity(user);
        UserEntity saved = queryUserRepository.save(userEntity);
        return userEntityMapper.mapToUser(saved);
    }
}
