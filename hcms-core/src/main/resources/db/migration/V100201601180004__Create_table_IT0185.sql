CREATE TABLE IT0185 (
  pernr bigint not null,
  subty character varying(4) not null,
  endda date not null,
  begda date not null,
  seqnr bigint,
  aedtm timestamp with time zone not null default timezone('utc'::text, now()),
  uname character varying(255) not null,
  ictyp character varying(5) not null,
  icnum character varying(30) not null,
  auth1 character varying(30),
  fpdat date,
  expid date,
  isspl character varying(30),
  iscot character varying(3)
);

ALTER TABLE IT0185 ADD PRIMARY KEY (pernr, subty, endda, begda);

COMMENT ON TABLE IT0185 IS 'Master data table for Personal IDs';

COMMENT ON COLUMN IT0185.pernr IS 'Employee SSN';

COMMENT ON COLUMN IT0185.subty IS 'Subtype';

COMMENT ON COLUMN IT0185.endda IS 'End Date';

COMMENT ON COLUMN IT0185.begda IS 'Begin Date';

COMMENT ON COLUMN IT0185.seqnr IS 'Info Type Record No.';

COMMENT ON COLUMN IT0185.aedtm IS 'Changed On';

COMMENT ON COLUMN IT0185.uname IS 'Changed By';

COMMENT ON COLUMN IT0185.ictyp IS 'IC Type';

COMMENT ON COLUMN IT0185.icnum IS 'Identity Number';

COMMENT ON COLUMN IT0185.auth1 IS 'Issuing Authority';

COMMENT ON COLUMN IT0185.fpdat IS 'Issuing Date';

COMMENT ON COLUMN IT0185.expid IS 'Expiry Date';

COMMENT ON COLUMN IT0185.isspl IS 'Place of Issue';

COMMENT ON COLUMN IT0185.iscot IS 'Country of Issue';
