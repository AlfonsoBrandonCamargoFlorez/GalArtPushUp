-- Cambiar a la base de datos
USE antiguedadess;

-- Inserciones en la tabla paises
INSERT INTO paises (nombre) VALUES ('Colombia');

-- Inserciones en la tabla regiones
INSERT INTO regiones (nombre, paises_id) VALUES ('Santander', 1);
INSERT INTO regiones (nombre, paises_id) VALUES ('Bogotá', 1);

-- Inserciones en la tabla ciudades
INSERT INTO ciudades (nombre, regiones_id) VALUES ('Bucaramanga', 1);
INSERT INTO ciudades (nombre, regiones_id) VALUES ('Piedecuesta', 1);
INSERT INTO ciudades (nombre, regiones_id) VALUES ('Bogotá D.C.', 2);

-- Inserciones en la tabla estado_persona
INSERT INTO estado_persona (descripcion) VALUES ('Activo');
INSERT INTO estado_persona (descripcion) VALUES ('Inactivo');

-- Inserciones en la tabla genero
INSERT INTO genero (nombre) VALUES ('Masculino');
INSERT INTO genero (nombre) VALUES ('Femenino');
INSERT INTO genero (nombre) VALUES ('LGBTIQ+XYZ');

-- Inserciones en la tabla persona
INSERT INTO persona (nombre, apellido, email, fecha_nacimiento, genero_id, estado_persona_id)
VALUES ('Juan', 'Pérez', 'juan.perez@example.com', '1990-01-15', 1, 1);
INSERT INTO persona (nombre, apellido, email, fecha_nacimiento, genero_id, estado_persona_id)
VALUES ('María', 'Gómez', 'maria.gomez@example.com', '1985-05-20', 2, 1);

-- Inserciones en la tabla tipo_direccion
INSERT INTO tipo_direccion (tipo) VALUES ('Residencial');
INSERT INTO tipo_direccion (tipo) VALUES ('Comercial');

-- Inserciones en la tabla direccion_persona
INSERT INTO direccion_persona (direccion, tipo_direccion_id, persona_id)
VALUES ('Calle 123, Bucaramanga', 1, 1);
INSERT INTO direccion_persona (direccion, tipo_direccion_id, persona_id)
VALUES ('Avenida 456, Bogotá', 1, 2);

-- Inserciones en la tabla empresa
INSERT INTO empresa (nombre, nit) VALUES ('Antigüedades S.A.S.', '900123456-1');

-- Inserciones en la tabla sucursal
INSERT INTO sucursal (nombre, empresa_id, ciudades_id) VALUES ('Sucursal Bucaramanga', 1, 1);
INSERT INTO sucursal (nombre, empresa_id, ciudades_id) VALUES ('Sucursal Bogotá', 1, 3);

-- Inserciones en la tabla empleado
INSERT INTO empleado (nombre, apellido, puesto, salario, comision, fecha_contratacion, persona_id)
VALUES ('Carlos', 'Ramírez', 'Gerente', 5000000, '10%', '2020-03-01', 1);
INSERT INTO empleado (nombre, apellido, puesto, salario, comision, fecha_contratacion, persona_id)
VALUES ('Sofía', 'Martínez', 'Vendedora', 3000000, '5%', '2021-07-15', 2);

-- Inserciones en la tabla tipo_transaccion
INSERT INTO tipo_transaccion (tipo) VALUES ('Compra');
INSERT INTO tipo_transaccion (tipo) VALUES ('Venta');

-- Inserciones en la tabla transacciones
INSERT INTO transacciones (monto, fecha, tipo_transaccion_id, comprador_id, vendedor_id)
VALUES (1500000, '2024-09-01', 1, 1, 2);
INSERT INTO transacciones (monto, fecha, tipo_transaccion_id, comprador_id, vendedor_id)
VALUES (2500000, '2024-09-10', 2, 2, 1);

-- Inserciones en la tabla epoca_antiguedad
INSERT INTO epoca_antiguedad (nombre) VALUES ('Antigüedad Clásica');
INSERT INTO epoca_antiguedad (nombre) VALUES ('Antigüedad Medieval');

-- Inserciones en la tabla antiguedades (con precio y estado_conservacion)
INSERT INTO antiguedades (nombre, descripcion, precio, estado_conservacion) 
VALUES ('Antiguo Jarrón', 'Un hermoso jarrón de la época clásica.', 100000, 'Bueno');
INSERT INTO antiguedades (nombre, descripcion, precio, estado_conservacion) 
VALUES ('Pintura Medieval', 'Una pintura representativa de la antigüedad medieval.', 150000, 'Excelente');

-- Inserciones en la tabla galeria
INSERT INTO galeria (descripcion, url_imagen) VALUES ('Galería de Arte', 'url_imagen2.jpg');

-- Inserciones en la tabla medio_pago
INSERT INTO medio_pago (tipo) VALUES ('Efectivo');
INSERT INTO medio_pago (tipo) VALUES ('Tarjeta de Crédito');

-- Inserciones en la tabla tipo_mov_caja
INSERT INTO tipo_mov_caja (tipo) VALUES ('Ingreso');
INSERT INTO tipo_mov_caja (tipo) VALUES ('Egreso');

-- Inserciones en ranking_antiguedad
INSERT INTO ranking_antiguedad (nombre, antiguedades_id) VALUES ('Antigüedad Alta', 1);
INSERT INTO ranking_antiguedad (nombre, antiguedades_id) VALUES ('Antigüedad Media', 2);

-- Inserciones en detalle_transaccion
INSERT INTO detalle_transaccion (transacciones_id, antiguedades_id) VALUES (1, 1);
INSERT INTO detalle_transaccion (transacciones_id, antiguedades_id) VALUES (2, 2);

-- Inserciones en historial_propiedad
INSERT INTO historial_propiedad (fecha_movimiento, actual_propietario_id, anterior_propietario_id, antiguedades_id) 
VALUES ('2024-09-10', 2, 1, 2);

-- Inserciones en clase_contacto
INSERT INTO clase_contacto (nombre) VALUES ('Cliente');
INSERT INTO clase_contacto (nombre) VALUES ('Proveedor');

-- Inserciones en contacto_persona
INSERT INTO contacto_persona (numero, persona_id, clasecontacto_id) VALUES ('3001234567', 1, 1);
INSERT INTO contacto_persona (numero, persona_id, clasecontacto_id) VALUES ('maria.gomez@example.com', 2, 1);

-- Inserciones en despachos
INSERT INTO despachos (estado, transacciones_id) VALUES ('Enviado', 1);
INSERT INTO despachos (estado, transacciones_id) VALUES ('Entregado', 2);

-- Inserciones en tipo_persona
INSERT INTO tipo_persona (tipo) VALUES ('Comprador');
INSERT INTO tipo_persona (tipo) VALUES ('Vendedor');

-- Inserciones en persona_tipo_persona
INSERT INTO persona_tipo_persona (persona_id, tipo_persona_id) VALUES (1, 1);  -- Comprador
INSERT INTO persona_tipo_persona (persona_id, tipo_persona_id) VALUES (2, 2);  -- Vendedor

-- Inserciones en transaccion_medio_pago
INSERT INTO transaccion_medio_pago (medio_pago_id, transaccion_id) VALUES (1, 1);
INSERT INTO transaccion_medio_pago (medio_pago_id, transaccion_id) VALUES (2, 2);
