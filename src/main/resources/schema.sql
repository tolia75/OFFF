CREATE TABLE IF NOT EXISTS cour
(
 cour_id SERIAL NOT NULL,
 type_de_cour varchar(6) NOT NULL ,
 date_du_cour DATE DEFAULT NULL,
 PRIMARY KEY (cour_id)
);
