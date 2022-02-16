CREATE TABLE IF NOT EXISTS cour
(
 cour_id SERIAL NOT NULL,
 type_de_cour varchar(6) NOT NULL ,
 date_du_cour DATE DEFAULT NULL,
 PRIMARY KEY (cour_id)
);

CREATE TABLE IF NOT EXISTS sportif
(
 sportif_id SERIAL NOT NULL,
 nom varchar(50) NOT NULL ,
 prenom varchar(50) NOT NULL,
 PRIMARY KEY (sportif_id)
);
