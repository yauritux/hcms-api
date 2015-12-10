CREATE TABLE T503K (
    MANDT character varying(10) not null PRIMARY KEY, 
    PERSK character varying(255) not null
);

COMMENT ON TABLE T503K IS 'Table master data for Employee Subgroup (Infotype T503K in SAP)';

COMMENT ON COLUMN T503K.MANDT IS 'Code of Employee Subgroup';

COMMENT ON COLUMN T503K.PERSK IS 'Name of Employee Subgroup';
