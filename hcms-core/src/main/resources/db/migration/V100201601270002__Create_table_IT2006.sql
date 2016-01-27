CREATE TABLE IT2006 (
  PERNR bigint NOT NULL,
  subty character varying(4) NOT NULL,
  endda DATE not null,
  begda DATE not null,
  seqnr bigint,
  aedtm timestamp with time zone not null default timezone('utc'::text, now()),
  uname character varying(255),
  mopgk character varying(5),
  mozko integer,
  ktart integer,
  anzhl decimal(7, 2),
  kverb decimal(10, 2),
  desta date,
  deend date 
);

ALTER TABLE IT2006 ADD PRIMARY KEY (PERNR, SUBTY, ENDDA, BEGDA);

COMMENT ON TABLE IT2006 IS 'Master data transaction for Absence Quotas';

COMMENT ON COLUMN IT2006.PERNR IS 'Employee SSN/ID';

COMMENT ON COLUMN IT2006.subty IS 'Subtype';

COMMENT ON COLUMN IT2006.endda IS 'End Date';

COMMENT ON COLUMN IT2006.begda IS 'Begin Date';

COMMENT ON COLUMN IT2006.seqnr IS 'Infotype Record No.';

COMMENT ON COLUMN IT2006.aedtm IS 'Changed On';

COMMENT ON COLUMN IT2006.uname IS 'Changed By';

COMMENT ON COLUMN IT2006.mopgk IS 'ESG Time Quota Types';

COMMENT ON COLUMN IT2006.mozko IS 'PS Grpg Tm Quota Type';

COMMENT ON COLUMN IT2006.KTART IS 'Absence Quota Type';

COMMENT ON COLUMN IT2006.anzhl IS 'Quota Number';

COMMENT ON COLUMN IT2006.kverb IS 'Quota Deduction';

COMMENT ON COLUMN IT2006.desta IS 'Deduction From';

COMMENT ON COLUMN IT2006.deend IS 'Deduction To';
