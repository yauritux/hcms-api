ALTER TABLE IT0022 ADD COLUMN infty character varying(10);

COMMENT ON COLUMN IT0022.infty IS 'Infotype';

UPDATE IT0022 SET infty='0022';

ALTER TABLE IT0022 ALTER COLUMN infty SET NOT NULL;
