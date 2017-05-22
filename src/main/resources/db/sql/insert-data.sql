INSERT INTO Roles (Descripcion) VALUES ('Administrador');
INSERT INTO Roles (Descripcion) VALUES ('Usuario');

INSERT INTO Privacidad (Descripcion) VALUES ('Publica');
INSERT INTO Privacidad (Descripcion) VALUES ('Privada');

INSERT INTO TiposTarea (Descripcion) VALUES ('Editable');
INSERT INTO TiposTarea (Descripcion) VALUES ('Solo lectura');

INSERT INTO Estados (Descripcion) VALUES ('Pendiente');
INSERT INTO Estados (Descripcion) VALUES ('Completa');
INSERT INTO Estados (Descripcion) VALUES ('Eliminada');

INSERT INTO Usuarios (Nombre, Apellido, Email, Password, RolId, Activo, FechaAlta) VALUES ('Admin', 'Admin', 'admin', 'admin', 1, true, '2010-3-12');
INSERT INTO Usuarios (Nombre, Apellido, Email, Password, RolId, Activo, FechaAlta) VALUES ('Usuario', 'Usuario', 'usuario@gmail.com', '123', 2, true, '2011-11-11');
INSERT INTO Usuarios (Nombre, Apellido, Email, Password, RolId, Activo, FechaAlta) VALUES ('TestNombre', 'TestApellido', 'testEmail@gmail.com', 'test', 2, false, '2014-11-11');
INSERT INTO Usuarios (Nombre, Apellido, Email, Password, RolId, Activo, FechaAlta) VALUES ('Juan', 'Lopez', 'juanlopez@gmail.com', 'password', 2, true, CURDATE());

INSERT INTO Tareas (Titulo, Descripcion, EstadoId, Privacidad, TipoTarea, UsuarioAlta, UsuarioAsignado, FechaAlta) VALUES ('Compras', 'Comprar Pan, Leche, Azucar y Cafe.', 1, 1, 1, 2, 2, '2012-11-11');
INSERT INTO Tareas (Titulo, Descripcion, EstadoId, Privacidad, TipoTarea, UsuarioAlta, UsuarioAsignado, FechaAlta) VALUES ('Estudiar', 'Estudiar para Seguridad.', 1, 1, 2, 2, 3, '2013-01-10');
INSERT INTO Tareas (Titulo, Descripcion, EstadoId, Privacidad, TipoTarea, UsuarioAlta, UsuarioAsignado, FechaAlta) VALUES ('Trabajar', 'Para conseguir dinero.', 2, 2, 2, 2, 2, CURDATE());
INSERT INTO Tareas (Titulo, Descripcion, EstadoId, Privacidad, TipoTarea, UsuarioAlta, UsuarioAsignado, FechaAlta) VALUES ('Limpiar', 'Para que no haya suciedad.', 1, 2, 1, 3, 4, CURDATE());
INSERT INTO Tareas (Titulo, Descripcion, EstadoId, Privacidad, TipoTarea, UsuarioAlta, UsuarioAsignado, FechaAlta) VALUES ('Transferencia', 'Para pagar auto', 2, 2, 1, 3, 2, CURDATE());

--COMMIT;