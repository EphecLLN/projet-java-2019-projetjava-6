
--Creation de la db
CREATE DATABASE Parking DEFAULT CHARACHTER SET utf8 COLLATE utf8_general_ci;  

--Creation d'un utilisateur admin ayant tout les droits
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'mdpadmin';
GRANT ALL ON Parking TO 'admin'@'localhost' IDENTIFIED BY 'mdpadmin';



--Creation des différentes tables
	--Creation de la table User
		CREATE TABLE Users(
			idUser INTEGER UNIQUE NOT NULL AUTO_INCREMENT, --id unique de l'utilisateur
			nameUser CHAR(50) NOT NULL, --nom de l'utilisateur
			firstNameUser CHAR(50) NOT NULL, --prénom de l'utilisateur
			phoneUser CHAR(15) NULL, --n° de tel de l'utilisateur
			mailUser CHAR(100) NULL, --mail de l'utilisateur
			plate CHAR(9) NOT NULL, --plaque de la voiture
			penality INTEGER DEFAULT (null), --Nbre de penalité, par défaut 0
		);

	--Creation de la table Parking
		CREATE TABLE Parking(
			idParking INTEGER UNIQUE NOT NULL AUTO_INCREMENT, 
			name CHAR(50) NOT NULL UNIQUE,
			position CHAR(100) NOT NULL,
			nbrPlace INTEGER NOT NULL,
			type CHAR(20) NOT NULL,
		);

	
	--Creation de la table Place
		CREATE TABLE Place(
			idPlace INTEGER NOT NULL AUTO_INCREMENT,
			parkingId INTEGER NOT NULL,
			placeNumber INTEGER NOT NULL,
			booked BINARY(1) NOT NULL,
		);
			
	
	
	
	--Creation de la table Reservation
		CREATE TABLE Reservation(
			idReservation INTEGER NOT NULL AUTO_INCREMENT,
			placeId INTEGER NOT NULL,
			userId INTEGER NOT NULL,
			dateStart DATE NOT NULL,
			dateEnd DATE NOT NULL
		);
	

		
		
		

	--Creation de la table Offence
		CREATE TABLE Offence(
			idOffence INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
			userSignal INTEGER NOT NULL, --fait référence à l'id de l'utilisateur
			userFlagged INTEGER NOT NULL, --fait référence à l'id de l'utilisateur
			commentOffence CHAR(250) NULL, --le commentaire sur le délit
			placeOffence INTEGER NOT NULL, --fait référence à l'id de la place
			dateOffence DATE NOT NULL,
			
			PRIMARY KEY (idOffence),
			FOREIGN KEY (userSignal) REFERENCES Users(idUser),
			FOREIGN KEY (userFlagged) REFERENCES Users(idUser),
			FOREIGN KEY (placeOffence) REFERENCES Place(idPlace)
		);
		
		
		
		
		
		
--Ajout de donnée dans la base
INSERT INTO Users (nameUser, firstNameUser, phoneUser, mailUser, plate) VALUES ('Gortz', 'Gaetan', '0478262700', 'he201732@students.ephec.be', '87tx3');


INSERT INTO Parking(name, position, nbrPlace, type) VALUES('Baudoin 1er', 'Boulevard Baudoin 1er Louvain-la-Neuve', 210, 'Gratuit');


INSERT INTO Place(parkingId, placeNumber, booked) VALUES (1, 1, 0);


INSERT INTO Reservation(placeId, userId, dateStart, dateEnd) VALUES (1, 1, 2019-09-16, 2020-06-25);



INSERT INTO Offence(




