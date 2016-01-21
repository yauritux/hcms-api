CREATE TABLE T517T (
  slart character(2) not null,
  stext character varying(50) not null
);

ALTER TABLE T517T ADD PRIMARY KEY (slart);

COMMENT ON TABLE T517T IS 'Master table for Education Grade';

COMMENT ON COLUMN T517T.slart IS 'Educational Est.';

COMMENT ON COLUMN T517T.stext IS 'Educational Est.Text';
