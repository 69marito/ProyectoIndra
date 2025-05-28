USE master;
GO
IF DB_ID ('Eventos_Sostenibles') IS NOT NULL
DROP DATABASE Eventos_Sostenibles;
GO
CREATE DATABASE Eventos_Sostenibles
GO
use Eventos_Sostenibles
create table organizadores(
    nombre varchar(30)  not null primary key,
    correo varchar(20),
)
create table telefonos(
    organizador varchar(30) not null references organizadores(nombre),
    telefono char(9),
    primary key(organizador,telefono) 
)
create table ubicaciones(
    nombre varchar(100) not null primary key
)
create table eventos(
    nombre varchar(30) not null primary key,
    fecha date not null,
    duracion smallint not null check (duracion > 0),
    ubicacion varchar(100) not null references ubicaciones(nombre),
    tipo varchar(100) not null,
    organizador varchar(30) not null references organizadores(nombre)
	    on update no action
	    on delete cascade
)
create table usuarios(
    correo varchar(60) not null primary key unique,
    nombre varchar(30)not null,
    contraseña varchar(30) not null
)
create table registran(
    evento varchar(30) not null references eventos(nombre),
    usuario varchar(60) not null references usuarios(correo)
	    on update no action
	    on delete cascade,
    asistentes smallint not null,
    primary key(evento, usuario)
)