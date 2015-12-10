CREATE TABLE T501 (
    PERSG character varying(10) not null PRIMARY KEY,
    PGTXT character varying(255) not null
);

COMMENT ON TABLE T501 IS 'Table master for Employee Group (Infotype T501 in SAP)';

COMMENT ON COLUMN T501.PERSG IS 'Employee Group ID';

COMMENT ON COLUMN T501.PGTXT IS 'Name of Employee Group';
