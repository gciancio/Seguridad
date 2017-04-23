DROP TABLE Usuarios IF EXISTS;
DROP TABLE Roles IF EXISTS;
DROP TABLE Tareas IF EXISTS;
DROP TABLE Estados IF EXISTS;

CREATE TABLE Usuarios (
  UsuarioId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY NOT NULL,
  Nombre 	VARCHAR(30) NOT NULL,
  Apellido 	VARCHAR(30) NOT NULL,
  Email  	VARCHAR(50) NOT NULL,
  Password	VARCHAR(20) NOT NULL,
  RolId		INTEGER REFERENCES Roles(RolId),
  Activo	BOOLEAN NOT NULL,
  FechaAlta	TIMESTAMP(2) NOT NULL
);

CREATE TABLE Roles (
  RolId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  Descripcion 	VARCHAR(30) NOT NULL
);

CREATE TABLE Tareas (
  TareaId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  Titulo	VARCHAR(30) NOT NULL,
  Descripcion 	VARCHAR(200),
  EstadoId	INTEGER REFERENCES Estados(EstadoId),
  TipoTarea	INTEGER REFERENCES TiposTarea(TipoTareaId),
  Editable	BOOLEAN NOT NULL,
  UsuarioAlta INTEGER REFERENCES Usuarios(UsuarioId),
  FechaAlta	TIMESTAMP(2) NOT NULL
);

CREATE TABLE TiposTarea (
  TipoTareaId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  Descripcion 	VARCHAR(30),
);

CREATE TABLE Estados (
  EstadoId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  Descripcion 	VARCHAR(30),
);