CREATE SCHEMA IF NOT EXISTS "MI_ESQUEMA";

CREATE TABLE IF NOT EXISTS "MI_ESQUEMA".persona (
    persona_id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    genero VARCHAR(10),
    edad INT,
    identificacion VARCHAR(20),
    direccion VARCHAR(100),
    telefono VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS "MI_ESQUEMA".cliente (
    cliente_id SERIAL PRIMARY KEY,
    contrasena VARCHAR(20) NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    persona_id INT NOT NULL,
    FOREIGN KEY (persona_id) REFERENCES "MI_ESQUEMA".persona(persona_id) ON DELETE CASCADE
);

INSERT INTO "MI_ESQUEMA".persona (nombre, genero, edad, identificacion, direccion, telefono) VALUES
('Juan Perez', 'Masculino', 30, '123456789', 'Calle Falsa 123', '555-1234'),
('Maria Lopez', 'Femenino', 25, '987654321', 'Avenida Siempre Viva 742', '555-5678'),
('Carlos Garcia', 'Masculino', 40, '543216789', 'Boulevard de los sueños 456', '555-8765');

INSERT INTO "MI_ESQUEMA".cliente (contrasena, estado, persona_id) VALUES
('password123', true, 1),  -- Juan Perez
('mypassword456', true, 2),  -- Maria Lopez
('carlospassword789', false, 3);  -- Carlos Garcia