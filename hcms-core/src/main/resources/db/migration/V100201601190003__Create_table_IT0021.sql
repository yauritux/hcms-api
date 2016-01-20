CREATE TABLE IT0021 (
  pernr bigint not null,
  subty character varying(4) not null,
  endda date not null,
  begda date not null,
  seqnr bigint,
  aedtm timestamp with time zone not null default timezone('utc'::text, now()),
  uname character varying(255),
  famsa character varying(4),
  fgbdt date,
  fgbld character varying(3),
  fanat character varying(3),
  fasex char(1),
  favor character varying(40),
  fanam character varying(40),
  fgbot character varying(40),
  fcnam character varying(80), 
  fknzn smallint,
  fnmzu char(1),
  title character varying(15)
);

COMMENT ON TABLE IT0021 IS 'Master Data for Emergency Infor';

COMMENT ON COLUMN IT0021.pernr IS 'Employee SSN';

COMMENT ON COLUMN IT0021.subty IS 'Subtype';

COMMENT ON COLUMN IT0021.endda IS 'End Date';

COMMENT ON COLUMN IT0021.begda IS 'Begin Date';

COMMENT ON COLUMN IT0021.seqnr IS 'Infotype Record No.';

COMMENT ON COLUMN IT0021.aedtm IS 'Changed On';

COMMENT ON COLUMN IT0021.uname IS 'Changed By';

COMMENT ON COLUMN IT0021.famsa IS 'Family Member';

COMMENT ON COLUMN IT0021.fgbdt IS 'Date of Birth';

COMMENT ON COLUMN IT0021.fgbld IS 'Country of Birth';

COMMENT ON COLUMN IT0021.fanat IS 'Nationality';

COMMENT ON COLUMN IT0021.fasex IS 'Gender';

COMMENT ON COLUMN IT0021.favor IS 'First Name';

COMMENT ON COLUMN IT0021.fanam IS 'Last Name';

COMMENT ON COLUMN IT0021.fgbot IS 'Birthplace';

COMMENT ON COLUMN IT0021.fcnam IS 'Full Name';

COMMENT ON COLUMN IT0021.fknzn IS 'Name Format Ind.';

COMMENT ON COLUMN IT0021.fnmzu IS 'Other Title';

COMMENT ON COLUMN IT0021.title IS 'Title';

ALTER TABLE IT0021 ADD PRIMARY KEY (pernr, subty, endda, begda);
