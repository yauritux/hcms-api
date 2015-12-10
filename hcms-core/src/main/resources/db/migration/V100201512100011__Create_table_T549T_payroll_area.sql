CREATE TABLE T549T (
    ABKRS character varying(10) NOT NULL PRIMARY KEY,
    ABKTX character varying(255) NOT NULL
);

COMMENT ON TABLE T549T IS 'Table master for Payroll Area (Infotype T549T in SAP)';

COMMENT ON COLUMN T549T.ABKRS IS 'Code of Payroll Area';

COMMENT ON COLUMN T549T.ABKTX IS 'Payroll Area Text'; 
