CREATE TABLE T016T (
  BRSCH character varying(10) NOT NULL,
  BRTXT character varying(255) NOT NULL
);

ALTER TABLE T016T ADD PRIMARY KEY (BRSCH);

COMMENT ON TABLE T016T IS 'Master data table for Industry';

COMMENT ON COLUMN T016T.BRSCH IS 'Industry Code';

COMMENT ON COLUMN T016T.BRTXT IS 'Industry Text Description';
