package com.proyecto2026.web.user.infrastructure.database.repository;

import com.proyecto2026.web.user.infrastructure.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryUserRepository extends JpaRepository<UserEntity, Long> {
    
}
