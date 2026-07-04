package com.petsproducts.user.infrastructure.database.repository;

import com.petsproducts.user.infrastructure.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueryUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String username);
}
