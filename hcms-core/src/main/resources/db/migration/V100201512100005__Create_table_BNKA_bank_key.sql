CREATE TABLE BNKA (
	BANKL character varying(15) NOT NULL PRIMARY KEY,
	BANKA character varying(60) NOT NULL,
	STRAS character varying(35),
	ORT01 character varying(35),
	ADRNR character varying(10),
	BRNCH character varying(40)
);

COMMENT ON TABLE BNKA IS 'Table master for Bank (Infotype BNKA in SAP)';

COMMENT ON COLUMN BNKA.BANKL IS 'Bank Key';

COMMENT ON COLUMN BNKA.BANKA IS 'Name of Bank';

COMMENT ON COLUMN BNKA.STRAS IS 'Street';

COMMENT ON COLUMN BNKA.ORT01 IS 'City';

COMMENT ON COLUMN BNKA.ADRNR IS 'Address Number';

COMMENT ON COLUMN BNKA.BRNCH IS 'Bank Branch';
