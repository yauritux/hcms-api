CREATE TABLE T527X (
    ORGEH BIGINT NOT NULL,
    ENDDA timestamp with time zone NOT NULL,
    BEGDA timestamp with time zone,
    ORGTX character varying(255) NOT NULL
);

ALTER TABLE T527X ADD PRIMARY KEY (ORGEH, ENDDA);

COMMENT ON TABLE T527X IS 'Table master for Organizational Unit (Infotype T527X in SAP)';

COMMENT ON COLUMN T527X.ORGEH IS 'Code of Organizational Unit';

COMMENT ON COLUMN T527X.ENDDA IS 'End Date';

COMMENT ON COLUMN T527X.BEGDA IS 'Start Date';

COMMENT ON COLUMN T527X.ORGTX IS 'Short Text of Organizational Unit';
