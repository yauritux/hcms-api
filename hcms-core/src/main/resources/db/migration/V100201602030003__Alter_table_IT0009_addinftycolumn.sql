ALTER TABLE IT0009 ADD COLUMN infty character varying(10);

COMMENT ON COLUMN IT0009.infty IS 'Infotype';

UPDATE IT0009 SET infty='0009';

ALTER TABLE IT0009 ALTER COLUMN infty SET NOT NULL;
