CREATE TABLE IT0001 (
  pernr bigint not null,
  endda timestamp with time zone not null,
  begda timestamp with time zone not null,
  seqnr bigint default 0,
  aedtm timestamp with time zone,
  uname character varying(100),
  werks character varying(10),
  bukrs character varying(10),
  persg character varying(10),
  persk character varying(10),
  vdsk1 character varying(14),
  gsber character varying(10),
  werks2 character varying(10),
  btrtl character varying(10),
  abkrs character varying(10),
  kokrs character varying(10),
  kostl character varying(10),
  orgeh bigint,
  endda_orgunit timestamp with time zone,
  plans bigint,
  endda_emposition timestamp with time zone,
  stell bigint,
  endda_empjob timestamp with time zone,
  mstbr character varying(8),
  sacha character varying(3),
  sachp character varying(3),
  sachz character varying(3),
  sname character varying(30),
  ename character varying(40),
  otype character varying(2),
  sbmod character varying(4)
);

ALTER TABLE IT0001 ADD PRIMARY KEY (pernr, endda, begda);

ALTER TABLE IT0001 ADD FOREIGN KEY (werks, bukrs) REFERENCES T500P (persa, bukrs) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0001 ADD FOREIGN KEY (persg) REFERENCES T501T (persg) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0001 ADD FOREIGN KEY (persk) REFERENCES T503K (mandt) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0001 ADD FOREIGN KEY (werks2, btrtl) REFERENCES V_001P_ALL (werks, btrtl) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0001 ADD FOREIGN KEY (abkrs) REFERENCES T549T (abkrs) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0001 ADD FOREIGN KEY (kokrs, kostl) REFERENCES CSKT (kokrs, kostl) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0001 ADD FOREIGN KEY (orgeh, endda_orgunit) REFERENCES T527X (orgeh, endda) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0001 ADD FOREIGN KEY (plans, endda_emposition) REFERENCES T528T (plans, endda) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0001 ADD FOREIGN KEY (stell, endda_empjob) REFERENCES T513S (stell, endda) ON UPDATE CASCADE ON DELETE RESTRICT;

COMMENT ON TABLE IT0001 IS 'Personnel Main Data';

COMMENT ON COLUMN IT0001.PERNR IS 'Employee Personnel Number';

COMMENT ON COLUMN IT0001.ENDDA IS 'End Date';

COMMENT ON COLUMN IT0001.BEGDA IS 'Begin Date';

COMMENT ON COLUMN IT0001.SEQNR IS 'Infotype Record No.';

COMMENT ON COLUMN IT0001.AEDTM IS 'Changed On.';

COMMENT ON COLUMN IT0001.UNAME IS 'Changed By.';

COMMENT ON COLUMN IT0001.WERKS IS 'Personnel Area';

COMMENT ON COLUMN IT0001.BUKRS IS 'Company Code';

COMMENT ON COLUMN IT0001.PERSG IS 'Employee Group';

COMMENT ON COLUMN IT0001.PERSK IS 'Employee Sub Group';

COMMENT ON COLUMN IT0001.VDSK1 IS 'Organizational Key';

COMMENT ON COLUMN IT0001.GSBER IS 'Business Area';

COMMENT ON COLUMN IT0001.WERKS2 IS 'Code of Personnel Area SubArea';

COMMENT ON COLUMN IT0001.BTRTL IS 'Personnel Sub Area';

COMMENT ON COLUMN IT0001.ABKRS IS 'Payroll Area';

COMMENT ON COLUMN IT0001.KOKRS IS 'Cost Center Code (Controlling Area code)';

COMMENT ON COLUMN IT0001.KOSTL IS 'Cost Center Code';

COMMENT ON COLUMN IT0001.ORGEH IS 'Organizational Unit';

COMMENT ON COLUMN IT0001.ENDDA_ORGUNIT IS 'Organizational Unit (End Date)';

COMMENT ON COLUMN IT0001.PLANS IS 'Position';

COMMENT ON COLUMN IT0001.ENDDA_EMPOSITION IS 'Position (End Date)';

COMMENT ON COLUMN IT0001.STELL IS 'JOB KEY';

COMMENT ON COLUMN IT0001.ENDDA_EMPJOB IS 'Job Key (End Date)';

COMMENT ON COLUMN IT0001.MSTBR IS 'Supervisor Area';

COMMENT ON COLUMN IT0001.SACHA IS 'Payroll Administrator';

COMMENT ON COLUMN IT0001.SACHP IS 'Pers.Administrator';

COMMENT ON COLUMN IT0001.SACHZ IS 'Time Administrator';

COMMENT ON COLUMN IT0001.SNAME IS 'Last Name First Name';

COMMENT ON COLUMN IT0001.ENAME IS 'Employee/Appl.Name';

COMMENT ON COLUMN IT0001.OTYPE IS 'Object Type';

COMMENT ON COLUMN IT0001.SBMOD IS 'Administrator Group';
