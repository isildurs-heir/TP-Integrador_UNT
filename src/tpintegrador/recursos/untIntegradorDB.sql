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
	  ('Ted','Mosby',357951);
      
INSERT INTO Vehiculo (marca,modelo,color,idCode,tipo,estado)
VALUES ('Ford','V3','Negro',245789,2,1),('Chevrolet','J5','Blanco',154321,1,1);

INSERT INTO Vehiculo (marca,modelo,color,idCode,tipo,estado)
VALUES ('VMW','E3','Gris',154698,1,0);

INSERT INTO Cliente (nombre,apellido,dni)
VALUES ('Barney','Stinson',123456);

INSERT INTO Vendido (idComprador,idVendedor,idCode)
VALUES (123456,159753,154698);

INSERT INTO Cliente (nombre,apellido,dni)
VALUES ('Lily','Aldrin',741852);

INSERT INTO Vehiculo (marca,modelo,color,idCode,tipo,estado)
VALUES ('Ford','K6','Negro',984321,2,0),('VMW','Y45','Blanco',369852,1,0);


INSERT INTO Vendido (idComprador,idVendedor,idCode)
VALUES (741852,159753,984321),(123456,357951,369852);

SELECT * FROM Empleado;
SELECT * FROM Vehiculo;


SELECT Vehiculo.marca,Vehiculo.modelo,Vehiculo.color,Vehiculo.idCode,Vehiculo.estado,Tipo.descripcion
FROM Vehiculo INNER JOIN Tipo on Vehiculo.tipo = Tipo.id;

SELECT Cliente.nombre,Cliente.apellido,Cliente.dni,Vehiculo.marca,Vehiculo.modelo
FROM Cliente INNER JOIN Vendido on Cliente.dni = Vendido.idComprador
			 INNER JOIN Vehiculo on Vehiculo.idCode = Vendido.idCode;

