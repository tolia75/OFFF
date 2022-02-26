DROP TABLE IF EXISTS cour_sportif;
DROP TABLE IF EXISTS sportif;
DROP TABLE IF EXISTS cour;

CREATE TABLE IF NOT EXISTS sportif
(
 sportif_id SERIAL NOT NULL,
 nom varchar(50) NOT NULL ,
 prenom varchar(50) NOT NULL,
 PRIMARY KEY (sportif_id)
);

CREATE TABLE IF NOT EXISTS cour
(
 cour_id SERIAL NOT NULL,
 type_de_cour varchar(6) NOT NULL ,
 date_du_cour DATE DEFAULT NULL,
 PRIMARY KEY (cour_id)
);

CREATE TABLE IF NOT EXISTS cour_sportif
(
 sportif_id integer NOT NULL,
 cour_id integer NOT NULL,
 PRIMARY KEY (sportif_id, cour_id),
 FOREIGN KEY (sportif_id) REFERENCES sportif(sportif_id),
 FOREIGN KEY (cour_id) REFERENCES cour(cour_id)
);
