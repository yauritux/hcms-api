CREATE TABLE CSKT (
    KOKRS character varying(10) NOT NULL,
    KOSTL character varying(10) NOT NULL,
    DATBI timestamp with time zone NOT NULL,
    KTEXT character varying(150) NOT NULL,
    KLTXT character varying(255),
    MCDS3 character varying(255) NOT NULL
);

ALTER TABLE CSKT ADD PRIMARY KEY (KOKRS, KOSTL, DATBI);

COMMENT ON TABLE CSKT IS 'Table master for Cost Center (Infotype CSKT in SAP)';

COMMENT ON COLUMN CSKT.KOKRS IS 'Controlling Area';

COMMENT ON COLUMN CSKT.KOSTL IS 'Cost Center';

COMMENT ON COLUMN CSKT.DATBI IS 'Valid To';

COMMENT ON COLUMN CSKT.KTEXT IS 'Name';

COMMENT ON COLUMN CSKT.KLTXT IS 'Description';

COMMENT ON COLUMN CSKT.MCDS3 IS 'Cost ctr short text';
