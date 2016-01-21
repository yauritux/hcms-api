CREATE TABLE T519T (
  SLABS character(2) NOT NULL,
  STEXT character varying(255) NOT NULL
);

ALTER TABLE T519T ADD PRIMARY KEY (SLABS);

COMMENT ON TABLE T519T IS 'Master data Table for Certificates';

COMMENT ON COLUMN T519T.SLABS IS 'Certificate Code';

COMMENT ON COLUMN T519T.STEXT IS 'Certificate Text';
