CREATE TABLE T005U (
	BLAND character varying(3) NOT NULL PRIMARY KEY,
	BEZEI character varying(20) NOT NULL
);

COMMENT ON TABLE T005U IS 'Table master for Region (Infotype T005U in SAP)';

COMMENT ON COLUMN T005U.BLAND IS 'Region Name';

COMMENT ON COLUMN T005U.BEZEI IS 'Description';
