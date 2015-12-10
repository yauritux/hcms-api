CREATE TABLE T001 (
	BUKRS character varying(10) NOT NULL PRIMARY KEY,
    BUTXT character varying(255) NOT NULL
);

COMMENT ON TABLE T001 IS 'Master data table for list of Company (Infotype T001 in SAP)';

COMMENT ON COLUMN T001.BUKRS IS 'Company Code';

COMMENT ON COLUMN T001.BUTXT IS 'Company Name';
