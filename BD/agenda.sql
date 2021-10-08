-- MySQL Script generated by MySQL Workbench
-- Sun Jan 24 17:44:02 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema restaurant
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema restaurant
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agenda` DEFAULT CHARACTER SET utf8mb4 ;

drop database if exists agenda;
create database agenda;
use agenda;

CREATE TABLE usuario
(
idUsuario int primary key not null,
nombre varchar(50),
apellidor varchar (50),
apellidom varchar (50),
numero varchar (10),
numcasa varchar (20),
correo varchar (50),
cumpleanios varchar (10),
notas varchar (250)
);

create table contacto 
(
idContacto int primary key not null auto_increment,
nombre varchar (50),
apellidor varchar (50),
apellidom varchar (50),
numero varchar (10),
correo varchar(100),
fechaNa varchar(20),
sexo varchar(10),
domicilio varchar(100)
);

create table grupoFamilia
(
id_contacto int primary key not null auto_increment,
nombreGrupo varchar (50),
FOREIGN KEY(id_Contacto) REFERENCES contacto (idContacto)
);

create table grupoAmigos
(
id_contacto int primary key not null auto_increment,
nombreGrupo varchar (50),
FOREIGN KEY(id_contacto) REFERENCES contacto (idContacto)
);


create table grupoTrabajo
(
id_contacto int primary key not null auto_increment,
nombreGrupo varchar (50),
FOREIGN KEY(id_contacto) REFERENCES contacto (idContacto)
);

insert into usuario (nombre, apellidor, apellidom, numero, numcasa, correo, cumpleanios, notas)
values("Ileana","Rivera","Hernandez","2474757789", "", "ileana@correo.com", "26/01", "me gusta el basket");


ALTER TABLE `contacto` AUTO_INCREMENT = 1;

DELIMITER $$
CREATE PROCEDURE InsertarContacto(nombre VARCHAR(50),apellidor VARCHAR(50), apellidom VARCHAR(50),numero VARCHAR(10), correo VARCHAR(100), fechaNa VARCHAR(20), sexo VARCHAR(10), domicilio VARCHAR (100))
BEGIN
insert into contacto (nombre, apellidor, apellidom, numero, correo, fechaNa, sexo, domicilio)
values (nombre, apellidor, apellidom, numero, correo, fechaNa, sexo, domicilio);
END $$

1
	
DROP PROCEDURE IF EXISTS InsertarGrupoFamilia;
DROP PROCEDURE IF EXISTS InsertarGrupoAmigos;
DROP PROCEDURE IF EXISTS InsertarGrupoTrabajo;

DELIMITER $$
CREATE PROCEDURE InsertarGrupoFamilia(nombreGrupo VARCHAR(50), id_contacto int)
BEGIN
insert into grupoFamilia (nombreGrupo, id_contacto)
values (nombreGrupo, id_contacto);
END $$

DELIMITER $$
CREATE PROCEDURE InsertarGrupoAmigos(nombreGrupo VARCHAR(50), id_contacto int)
BEGIN
insert into grupoAmigos(nombreGrupo, id_contacto)
values (nombreGrupo, id_contacto);
END $$

DELIMITER $$
CREATE PROCEDURE InsertarGrupoTrabajo(nombreGrupo VARCHAR(50), id_contacto int)
BEGIN
insert into grupoTrabajo (nombreGrupo, id_contacto)
values (nombreGrupo, id_contacto);
END $$



CALL InsertarGrupoFamilia ("Familia", 2);
CALL InsertarGrupoFamilia ("Familia", 4);

CALL InsertarContacto ("Karen","Contreras","Vega","24747577883", "karen@correo.com", "27/08", "f", "Boulevard 16 de septiembre #305");
CALL InsertarContacto ("Viridiana Leila","Rivera","Hernandez","2474713632", "leila@correo.com", "09/12", "f", "San felipe #78");
CALL InsertarContacto ("Ivan Said","Rivera","Hernandez","2471324514", "ivan@correo.com", "31/10", "m", "Hidalgo poniente #309");
CALL InsertarContacto ("Katia","Rodriguez","Hernandez","241258964", "katia@correo.com", "26/01", "f", "Jardines 360");
CALL InsertarContacto ("Berenice","Hernandez","Rivera","2414896320", "berenice@correo.com", "25/09", "f", "Calle siempre viva");
CALL InsertarContacto ("Elias","Rocha","Patiño","2471185397", "elias@correo.com", "20/12", "m", "Matamoros poniente #6");
CALL InsertarContacto ("Julio","Vazquez","Vazquez","2468549321", "julio@correo.com", "09/11", "m", "Galeana sur #453");

select * from contacto;

delete from contacto where idContacto = 10

select * from usuario;
select * from grupoFamilia;
select * from grupoAmigos;
select * from grupoTrabajo;

Select idContacto from contacto where nombre = "Katia"

select idContacto, nombre, apellidor, apellidom, numero from contacto inner join grupoFamilia on idContacto = id_contacto