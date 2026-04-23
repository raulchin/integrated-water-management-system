-- tabla socios
create table if not exists socios(
    id_socio        SERIAL PRIMARY KEY ,
    cedula_ruc      VARCHAR(20) UNIQUE NOT NULL,
    nombres         VARCHAR(100) NOT NULL,
    apellidos       VARCHAR(100) NOT NULL,
    direccion       TEXT,
    telefono        VARCHAR(20) NOT NULL,
    email           VARCHAR(100),
    estado          BOOLEAN DEFAULT TRUE, -- Activo/Inactivo
    fecha_registro  DATE DEFAULT CURRENT_DATE
);

-- crear un index 
create index idx_socios_nombres on socios(apellidos,nombres);
