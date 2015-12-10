CREATE TABLE T005T (
	LAND1 character varying(3) NOT NULL PRIMARY KEY,
	LANDX character varying(15) NOT NULL,
	NATIO character varying(15) NOT NULL
);

COMMENT ON TABLE T005T IS 'Table master for Country (Infotype T005T in SAP)';

COMMENT ON COLUMN T005T.LAND1 IS 'Country Key';

COMMENT ON COLUMN T005T.LANDX IS 'Country Name';

COMMENT ON COLUMN T005T.NATIO IS 'Nationality Name';
