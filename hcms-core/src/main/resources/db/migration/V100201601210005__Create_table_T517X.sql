CREATE TABLE T517X (
  FAART character varying(5) NOT NULL,
  FTEXT character varying(255) NOT NULL
);

ALTER TABLE T517X ADD PRIMARY KEY (FAART);

COMMENT ON TABLE T517X IS 'Master data Table for Branch of Study';

COMMENT ON COLUMN T517X.FAART IS 'Branch of Study Code';

COMMENT ON COLUMN T517X.FTEXT IS 'Branch of Study Text';
