/*DROP DATABASE untIntegrador;*/
CREATE DATABASE untIntegrador;
USE untIntegrador;

DROP TABLE IF EXISTS Tipo;
CREATE TABLE Tipo(
	id INT AUTO_INCREMENT,
    descripcion VARCHAR(20),
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS Empleado;
CREATE TABLE Empleado(
	nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    dni INT,
    PRIMARY KEY(dni)
);

DROP TABLE IF EXISTS Vehiculo;
CREATE TABLE Vehiculo(
    marca VARCHAR(25) NOT NULL,
    modelo VARCHAR(25) NOT NULL,
    color VARCHAR(25) NOT NULL,
    idCode INT,
    tipo INT,
    estado INT,
    PRIMARY KEY(idCode),
	CONSTRAINT fk_tipo
		FOREIGN KEY (tipo)
		REFERENCES Tipo(id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS Cliente;
CREATE TABLE Cliente(
	nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    dni INT,
    PRIMARY KEY(dni)
);

DROP TABLE IF EXISTS Vendido;
CREATE TABLE Vendido(
	idComprador INT,
    idVendedor INT,
    idCode INT,
    CONSTRAINT fk_vendedor
		FOREIGN KEY (idVendedor)
        REFERENCES Empleado(dni)
			ON DELETE CASCADE
            ON UPDATE NO ACTION,
    CONSTRAINT fk_comprador
		FOREIGN KEY (idComprador)
        REFERENCES Cliente(dni)
			ON DELETE CASCADE
            ON UPDATE NO ACTION,
	CONSTRAINT fk_vehiculoVendido
		FOREIGN KEY (idCode)
        REFERENCES Vehiculo(idCode)
			ON DELETE CASCADE
            ON UPDATE NO ACTION
);

INSERT INTO Tipo (descripcion)
VALUES ('Auto'),('Utilitario'),('Camion');

INSERT INTO Empleado (nombre,apellido,dni)
VALUES('Marshall','Eriksen',159753),
	  ('Ted','Mosby',357951),
      ('Robin','Scherbatsky',852456);
      
INSERT INTO Vehiculo (marca,modelo,color,idCode,tipo,estado) /*DISPONIBLES*/
VALUES ('Ford','V3','Negro',245789,2,1),
	   ('Chevrolet','J5','Blanco',154322,1,1),
       ('Chevrolet','J4','Negro',154323,2,1),
       ('Chevrolet','J6','Gris',154324,3,1),
       ('Mercedez Benz','M3','Rojo',693258,3,1),
       ('Mercedez Benz','M1','Negro',693259,1,1),
       ('Ford','V1','Blanco',245788,1,1),
       ('Ford','V2','Azul',245787,1,1),
       ('Ford','V4','Rojo',245786,1,1),
       ('VMW','E1','Blanco',321654,1,1),
       ('VMW','E2','Azul',321655,1,1),
       ('VMW','E3','Rojo',321656,1,1),
       ('VMW','E4','Negro',321657,1,1);

INSERT INTO Vehiculo (marca,modelo,color,idCode,tipo,estado)  /*VENDIDOS*/
VALUES ('VMW','E7','Gris',154678,1,0),
	   ('Chevrolet','J9','Negro',154687,2,0),
       ('Mercedez Benz','M5','Rojo',693693,3,0),
       ('Ford','V9','Blanco',245999,1,0);
       
       

INSERT INTO Cliente (nombre,apellido,dni)
VALUES ('Barney','Stinson',123456),
	   ('Lily','Aldrin',741852),
       ('James','Stinson',486426);
       
INSERT INTO Vendido (idComprador,idVendedor,idCode)
VALUES (123456,852456,154678),
	   (123456,357951,154687),
       (741852,357951,693693),
       (741852,852456,245999);



SELECT * FROM Empleado;
SELECT * FROM Vehiculo;
SELECT * FROM Cliente;


SELECT Vehiculo.marca,Vehiculo.modelo,Vehiculo.color,Vehiculo.idCode,Vehiculo.estado,Tipo.descripcion
FROM Vehiculo INNER JOIN Tipo on Vehiculo.tipo = Tipo.id;

SELECT idCode,idVendedor FROM Vendido WHERE idComprador = 741852;
             

