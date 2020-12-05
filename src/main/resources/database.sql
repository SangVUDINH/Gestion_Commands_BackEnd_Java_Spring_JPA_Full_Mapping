-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
SET GLOBAL time_zone = '+3:00';

DROP DATABASE IF EXISTS KOORTP1;
CREATE DATABASE KOORTP1;
USE KOORTP1;


-- -----------------------------------------------------------------------------
-- - Construction de la table des informations utilisateurs                  ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_UserInformations (
    idInformations      int    PRIMARY KEY AUTO_INCREMENT,
    address             text,
    city                text,
    email               text,
    phoneNumber         text
);

INSERT INTO T_UserInformations (address, city, email, phoneNumber) 
VALUES ( 'Inconnue', 'La matrice', 'neo@matrix.com', '1234567890' ),
       ( 'rue du Faucon', 'L''étoile noire', 'luke@glaforce.wars', '0147258369' ),
       ( '1997, Manhattan', 'New York', 'snake@carpenter.com', '9638527410' ),
       ( 'Nostromo', 'La bas', 'ripley@nostromo.alien', '9876543210' ),
       ( 'SIS Building', 'London', '007@mi6.uk', '7007007007' );

SELECT * FROM T_UserInformations;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Users (
    idUser              int         PRIMARY KEY AUTO_INCREMENT,
    login               varchar(20) NOT NULL,
    password            varchar(20) NOT NULL,
    connectionNumber    int         NOT NULL DEFAULT 0,
    idUserInformations  int         UNIQUE NOT NULL REFERENCES T_UserInformations(idInformations)
);

INSERT INTO T_Users (login, password, idUserInformations) 
VALUES ( 'Anderson',    'Neo', 1 ),
       ( 'Skywalker',   'Luke', 2 ),
       ( 'Plissken',    'Snake', 3 ),
       ( 'Ripley',      'Ellen', 4 ),
       ( 'Bond',        'James', 5 );

SELECT * FROM T_Users;

-- -----------------------------------------------------------------------------
-- - Construction de la table des commandes                                 ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Commands (
    idCommand       int         PRIMARY KEY AUTO_INCREMENT,
    idUser          int         NOT NULL REFERENCES T_Users(IdUser),
    commandDate     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO T_Commands (idUser)
VALUES (1), (2), (1);

CREATE TABLE T_Articles (
	idArticle 	int	PRIMARY KEY AUTO_INCREMENT,
	description varchar(100),
	brand		varchar(20),
	price		real
	);
	
INSERT INTO T_Articles (description) 
VALUES ("USB"),("ORDI"),("PC");

CREATE TABLE T_CommandLines (
	idCommandLine	int 	PRIMARY KEY AUTO_INCREMENT,
	idCommand		int 	NOT NULL REFERENCES T_Commands(idCommand),
	idArticle		int 	NOT NULL REFERENCES T_Articles(idArticle),
	quantity		int
	);
	
INSERT INTO T_CommandLines (idCommand,idArticle, quantity)
VALUES (1,1,50),(2,2,10);

-- -----------------------------------------------------------------------------
-- - Construction de la table des rôles                                      ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Roles (
    idRole       int         PRIMARY KEY AUTO_INCREMENT,
    roleName     varchar(20) NOT NULL
);

INSERT INTO T_Roles (roleName)
VALUES ('client'), ('admin'), ('stockManager');

SELECT * FROM T_Roles;

-- -----------------------------------------------------------------------------
-- - Construction de la table d'association T_Users/T_Roles                  ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Users_Roles_Associations (
    idUser   int     NOT NULL REFERENCES T_Users(idUser),
    idRole   int     NOT NULL REFERENCES T_Roles(idRole)
);

INSERT INTO T_Users_Roles_Associations VALUES (1, 2), (1, 3), (4, 1), (5, 1);

-- -----------------------------------------------------------------------------
-- - Construction de la table des paiements                                  ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Payments (
    idPayment           int          PRIMARY KEY AUTO_INCREMENT,
    amount              double       NOT NULL,
    paymentDate         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO T_Payments (amount, paymentDate) 
VALUES ( 1295, now() ),
       ( 245, now() );

SELECT * FROM T_Payments;

-- -----------------------------------------------------------------------------
-- - Construction de la table des paiements paypal                           ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_PaypalPayments (
    idPayment           int          NOT NULL REFERENCES T_Payments(idPayment),
    accountNumber       varchar(30)
);

INSERT INTO T_PaypalPayments VALUES ( 1, 'A fake paypal account' );

SELECT * FROM T_PaypalPayments;

-- -----------------------------------------------------------------------------
-- - Construction de la table des paiements par cartes bleues                ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_CreditCardPayments (
    idPayment           int          NOT NULL REFERENCES T_Payments(idPayment),
    cardNumber          char(24),
    expirationDate      varchar(5)
);

INSERT INTO T_CreditCardPayments VALUES ( 2, '1234 5678 9012 3456', '06/19' );

SELECT * FROM T_CreditCardPayments;

CREATE TABLE T_Commands_Payments_Associations (
	idCommand 			int 		NOT NULL REFERENCES T_Commands(idCommand),
	idPayment           int         NOT NULL REFERENCES T_Payments(idPayment)
);

INSERT INTO T_Commands_Payments_Associations 
VALUES ( 1, 1 ), ( 2, 2 );
