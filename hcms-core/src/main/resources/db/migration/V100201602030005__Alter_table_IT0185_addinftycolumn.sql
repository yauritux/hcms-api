ALTER TABLE IT0185 ADD COLUMN infty character varying(10);

COMMENT ON COLUMN IT0185.infty IS 'Infotype';

UPDATE IT0185 SET infty='0185';

ALTER TABLE IT0185 ALTER COLUMN infty SET NOT NULL;
