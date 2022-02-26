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

INSERT INTO sportif VALUES (1, 'nom', 'prenom');
INSERT INTO sportif VALUES (2, 'nom', 'prenom');
INSERT INTO sportif VALUES (3, 'nom', 'prenom');
INSERT INTO cour VALUES (1, '1', '2022-02-14');
INSERT INTO cour VALUES (2, '2', '2022-02-14');
INSERT INTO cour VALUES (3, '3', '2022-02-14');
INSERT INTO cour_sportif VALUES (1, 1);


