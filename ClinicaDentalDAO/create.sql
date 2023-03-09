CREATE TABLE IF NOT EXISTS Domicilio (id INT AUTO_INCREMENT PRIMARY KEY, calle VARCHAR(255), numero INT, localidad VARCHAR(255), provincia VARCHAR(50));
CREATE TABLE IF NOT EXISTS Paciente (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), dni VARCHAR(255), id_domicilio INT, FOREIGN KEY (id_domicilio) REFERENCES Domicilio(id), fecha_ingreso VARCHAR(25));
