package com.sigap.authserver.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUser;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "nombres", nullable = false, length = 100)
    private String names;

    @Column(name = "estado", nullable = false)
    private Boolean statusUser = true;

    @Column(name = "intentos_fallidos", nullable = false)
    private Integer failedAttempts = 0;

    @Column(name = "bloqueado", nullable = false)
    private Boolean blocked = false;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime creationDateUser;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRolEntity> usuariosRol = new HashSet<>();

    @PrePersist
    void prePersist() {
        if (creationDateUser == null) {
            creationDateUser = LocalDateTime.now();
        }
        if (statusUser == null) {
            statusUser = true;
        }
        if (blocked == null) {
            blocked = false;
        }
        if (failedAttempts == null) {
            failedAttempts = 0;
        }
    }

    @PreUpdate
    void preUpdate() {
        updateDate = LocalDateTime.now();
    }

    public void agregarRol(RolEntity rol) {
        UserRolEntity usuarioRol = new UserRolEntity(this, rol);
        usuariosRol.add(usuarioRol);
        rol.getUsersRol().add(usuarioRol);
    }
}
