DROP DATABASE untIntegrador;
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
    vendidoPor INT,
    PRIMARY KEY(idCode),
    CONSTRAINT fk_vendidopor
		FOREIGN KEY (vendidoPor)
        REFERENCES Empleado(dni)
		ON DELETE CASCADE
		ON UPDATE NO ACTION,
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
    vehiculoComprado INT,
    PRIMARY KEY(dni),
    CONSTRAINT fk_vehiculo
		FOREIGN KEY (vehiculoComprado)
        REFERENCES Vehiculo(idCode)
			ON DELETE CASCADE
            ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS Vendido;
CREATE TABLE Vendido(
	idComprador INT,
    idCode INT,
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
	  ('Ted','Mosby',357951);
      
INSERT INTO Vehiculo (marca,modelo,color,idCode,tipo,estado)
VALUES ('Ford','V3','Negro',245789,2,1),('Chevrolet','J5','Blanco',154321,1,1);

INSERT INTO Vehiculo (marca,modelo,color,idCode,tipo,estado,vendidoPor)
VALUES ('VMW','E3','Gris',154698,1,0,159753);

INSERT INTO Cliente (nombre,apellido,dni)
VALUES ('Barney','Stinson',123456);

UPDATE Cliente SET vehiculoComprado = 154698 WHERE dni = 123456;

INSERT INTO Vendido (idComprador,idCode)
VALUES (123456,154698);

SELECT Vehiculo.marca,Vehiculo.modelo,Vehiculo.color,Tipo.descripcion,Vehiculo.estado,Vehiculo.vendidoPor,Vehiculo.idCode
FROM Vehiculo INNER JOIN Tipo on Vehiculo.tipo = Tipo.id;
