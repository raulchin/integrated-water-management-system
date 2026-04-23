package com.sigap.authserver.repository;

import com.sigap.authserver.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @EntityGraph(attributePaths = {"usuariosRol", "usuariosRol.rol"})
    Optional<UserEntity> findWithRolesByUsername(String username);
}
