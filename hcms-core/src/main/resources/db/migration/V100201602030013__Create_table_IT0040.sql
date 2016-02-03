CREATE TABLE IT0040 (
  PERNR bigint NOT NULL,
  INFTY character varying(10) NOT NULL,
  SUBTY character varying(4) NOT NULL,
  ENDDA date NOT NULL,
  BEGDA date NOT NULL,
  SEQNR bigint,
  AEDTM timestamp with time zone not null default timezone('utc'::text, now()),
  UNAME character varying(255),
  ITXEX character varying(5),
  LEIHG character varying(4) NOT NULL,
  ANZKL NUMERIC(15,2),
  ZEINH character(3),
  LOBNR character varying(25)
);

COMMENT ON TABLE IT0040 IS 'Employee Inventory (Objects on Loan)';

COMMENT ON COLUMN IT0040.PERNR IS 'Employee SSN/ID';

COMMENT ON COLUMN IT0040.INFTY IS 'Infotype';

COMMENT ON COLUMN IT0040.SUBTY IS 'Subtype';

COMMENT ON COLUMN IT0040.ENDDA IS 'End Date';

COMMENT ON COLUMN IT0040.BEGDA IS 'Begin Date';

COMMENT ON COLUMN IT0040.SEQNR IS 'Infotype Record No.';

COMMENT ON COLUMN IT0040.AEDTM IS 'Changed On';

COMMENT ON COLUMN IT0040.UNAME IS 'Changed By';

COMMENT ON COLUMN IT0040.ITXEX IS 'Text Exists';

COMMENT ON COLUMN IT0040.LEIHG IS 'Object on Loan';

COMMENT ON COLUMN IT0040.ANZKL IS 'Number/Unit';

COMMENT ON COLUMN IT0040.ZEINH IS 'Unit of time/meas.';

COMMENT ON COLUMN IT0040.LOBNR IS 'Loan object number';
