ALTER TABLE IT0009 DROP CONSTRAINT it0009_pkey;

ALTER TABLE IT0009 ADD PRIMARY KEY (pernr, infty, subty, endda, begda);
