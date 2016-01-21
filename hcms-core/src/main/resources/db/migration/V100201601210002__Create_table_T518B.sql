CREATE TABLE T518B (
  AUSBI bigint not null,
  ATEXT character varying(255) not null
);

ALTER TABLE T518B ADD PRIMARY KEY (AUSBI);

COMMENT ON TABLE T518B IS 'Master data table for Education Program/Training';

COMMENT ON COLUMN T518B.AUSBI IS 'Education/Training Code';

COMMENT ON COLUMN T518B.ATEXT IS 'Education/Training Text';
