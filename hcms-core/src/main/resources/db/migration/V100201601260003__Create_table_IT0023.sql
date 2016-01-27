CREATE TABLE IT0023 (
  pernr bigint NOT NULL,
  endda date NOT NULL,
  begda date NOT NULL,
  seqnr bigint,
  aedtm timestamp with time zone not null default timezone('utc'::text, now()),
  uname character varying(255),
  arbgb character varying(255),
  ort01 character varying(100),
  land1 character varying(3),
  branc character varying(10),
  taete bigint, 
  ansvx character varying(20)
);

COMMENT ON TABLE IT0023 IS 'Master data table for Employment History';

COMMENT ON COLUMN IT0023.pernr IS 'Employee SSN/ID';

COMMENT ON COLUMN IT0023.endda IS 'End Date';

COMMENT ON COLUMN IT0023.begda IS 'Begin Date';

COMMENT ON COLUMN IT0023.seqnr IS 'Infotype Record No.';

COMMENT ON COLUMN IT0023.aedtm IS 'Changed On';

COMMENT ON COLUMN IT0023.uname IS 'Changed By';

COMMENT ON COLUMN IT0023.arbgb IS 'Employer';

COMMENT ON COLUMN IT0023.ort01 IS 'City';

COMMENT ON COLUMN IT0023.land1 IS 'Country Key';

COMMENT ON COLUMN IT0023.branc IS 'Industry';

COMMENT ON COLUMN IT0023.taete IS 'Job';

COMMENT ON COLUMN IT0023.ansvx IS 'Work Contract';
