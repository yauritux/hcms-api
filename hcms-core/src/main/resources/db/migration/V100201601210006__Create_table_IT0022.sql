CREATE TABLE IT0022 (
  PERNR bigint NOT NULL,
  SUBTY character varying(4) NOT NULL,
  ENDDA DATE NOT NULL,
  BEGDA DATE NOT NULL,
  SEQNR BIGINT,
  AEDTM timestamp with time zone not null default timezone('utc'::text, now()),
  UNAME character varying(255),
  SLART character(2),
  INSTI character varying(255),
  SLAND character varying(3),
  AUSBI bigint,
  SLABS character(2),
  ANZKL decimal(3,2),
  ANZEH character(3),
  SLTP1 character varying(5),
  SLTP2 character varying(5),
  JBEZ1 decimal(15,2),
  SCHCD character varying(10),
  FACCD character varying(3),
  EMARK character varying(4)
);

COMMENT ON TABLE IT0022 IS 'Master data table for Employee Education';

COMMENT ON COLUMN IT0022.PERNR IS 'Employee SSN';

COMMENT ON COLUMN IT0022.SUBTY IS 'Subtype';

COMMENT ON COLUMN IT0022.ENDDA IS 'End Date';

COMMENT ON COLUMN IT0022.BEGDA IS 'Begin Date';

COMMENT ON COLUMN IT0022.SEQNR IS 'Infotype Record No.';

COMMENT ON COLUMN IT0022.AEDTM IS 'Changed On';

COMMENT ON COLUMN IT0022.UNAME IS 'Changed By';

COMMENT ON COLUMN IT0022.SLART IS 'Educational Est.';

COMMENT ON COLUMN IT0022.INSTI IS 'Institute/Location';

COMMENT ON COLUMN IT0022.SLAND IS 'Country Key';

COMMENT ON COLUMN IT0022.AUSBI IS 'Education/Training';

COMMENT ON COLUMN IT0022.SLABS IS 'Certificate';

COMMENT ON COLUMN IT0022.ANZKL IS 'Duration of Course';

COMMENT ON COLUMN IT0022.ANZEH IS 'Unit of Time/Meas.';

COMMENT ON COLUMN IT0022.SLTP1 IS 'Branch of Study 1';

COMMENT ON COLUMN IT0022.SLTP2 IS 'Branch of Study 2';

COMMENT ON COLUMN IT0022.JBEZ1 IS 'Course Fees';

COMMENT ON COLUMN IT0022.SCHCD IS 'Ins./School Code';

COMMENT ON COLUMN IT0022.FACCD IS 'Faculty Code';

COMMENT ON COLUMN IT0022.EMARK IS 'Final Grade';
