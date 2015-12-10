CREATE TABLE T528T (
    PLANS BIGINT NOT NULL,
    ENDDA timestamp with time zone NOT NULL,
    BEGDA timestamp with time zone,
    PLSTX character varying(150) NOT NULL
);

ALTER TABLE T528T ADD PRIMARY KEY (PLANS, ENDDA);

COMMENT ON TABLE T528T IS 'Table master for Position';

COMMENT ON COLUMN T528T.PLANS IS 'Position';

COMMENT ON COLUMN T528T.ENDDA IS 'End Date';

COMMENT ON COLUMN T528T.BEGDA IS 'Start Date';

COMMENT ON COLUMN T528T.PLSTX IS 'Position (Short Text)';
