CREATE TABLE T556B (
  MOPGK character varying(5) NOT NULL,
  MOZKO int NOT NULL,
  KTART int NOT NULL,
  KTEXT character varying(50) NOT NULL
);

ALTER TABLE T556B ADD PRIMARY KEY (MOPGK, MOZKO, KTART);

COMMENT ON TABLE T556B IS 'Master data table for Absence Quota Types';

COMMENT ON COLUMN T556B.MOPGK IS 'ESG Time Quota Types';

COMMENT ON COLUMN T556B.MOZKO IS 'PS Grpg Tm Quota Type';

COMMENT ON COLUMN T556B.KTART IS 'Absence Quota Type';

COMMENT ON COLUMN T556B.KTEXT IS 'Quota Text';
