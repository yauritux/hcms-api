CREATE TABLE T5R06 (
  ICTYP character varying(5) NOT NULL,
  ICTXT character varying(255) NOT NULL
);

ALTER TABLE T5R06 ADD PRIMARY KEY (ICTYP);

COMMENT ON TABLE T5R06 IS 'Master data for type of Personal IDs';

COMMENT ON COLUMN T5R06.ICTYP IS 'IC Type';

COMMENT ON COLUMN T5R06.ICTXT IS 'IC Description';