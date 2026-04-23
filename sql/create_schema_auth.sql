
CREATE TABLE if not exists roles (
    id_rol           BIGSERIAL PRIMARY KEY,
    nombre           VARCHAR(100) NOT NULL UNIQUE,
    descripcion      VARCHAR(150),
    estado           BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE if not exists usuarios(
    id_usuario                 SERIAL PRIMARY KEY,
    username                VARCHAR(100) NOT NULL,
    password_hash           VARCHAR(255) NOT NULL,
    email                   VARCHAR(100) NOT NULL,
    nombres                 VARCHAR(100) NOT NULL,
    estado                  BOOLEAN NOT NULL DEFAULT TRUE,
    intentos_fallidos       INT NOT NULL DEFAULT 0,
    bloqueado               BOOLEAN NOT NULL DEFAULT FALSE,
    fecha_creacion          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion     TIMESTAMP
);

CREATE TABLE if not exists usuario_roles (
    id_usuario             BIGINT NOT NULL,
    id_rol              BIGINT NOT NULL,
    fecha_asignacion    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_usuario, id_rol), CONSTRAINT fk_usuario_roles_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    CONSTRAINT fk_usuario_roles_rol FOREIGN KEY (id_rol) REFERENCES roles(id_rol)
);