ALTER TABLE IT2006 ADD COLUMN infty character varying(10);

COMMENT ON COLUMN IT2006.infty IS 'Infotype';

UPDATE IT2006 SET infty='2006';

ALTER TABLE IT2006 ALTER COLUMN infty SET NOT NULL;
