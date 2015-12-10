CREATE TABLE T042Z (
	ZLSCH char(1) NOT NULL PRIMARY KEY,
	TEXT1 character varying(30) NOT NULL
);

COMMENT ON TABLE T042Z IS 'Table master for Payment Method (Infotype T042Z in SAP)';

COMMENT ON COLUMN T042Z.ZLSCH IS 'Payment method Code';

COMMENT ON COLUMN T042Z.TEXT1 IS 'Payment method name (in language of Country)';
