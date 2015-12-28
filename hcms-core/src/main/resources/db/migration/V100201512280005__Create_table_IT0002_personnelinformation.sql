CREATE TABLE IT0002 (
  pernr BIGINT NOT NULL,
  endda date NOT NULL,
  begda date NOT NULL,
  seqnr BIGINT DEFAULT 0,
  aedtm timestamp with time zone NOT NULL,
  uname character varying(15) NOT NULL,
  nachn character varying(40),
  cname character varying(80),
  art character varying(2),
  title character varying(15),
  art2 character varying(2),
  title2 character varying(15),
  art3 character varying(2),
  title3 character varying(15),
  rufnm character varying(40),
  knznm character varying(50),
  anred character varying(2),
  gesch character varying(80),
  gbdat date,
  gblnd character varying(3),
  gbort character varying(40),
  sprsl character varying(3),
  konfe character varying(2),
  famst character varying(2),
  famdt date,
  anzkd smallint 
);

ALTER TABLE IT0002 ADD PRIMARY KEY (pernr, endda, begda);

ALTER TABLE IT0002 ADD FOREIGN KEY (art, title) REFERENCES T535N (art, title) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0002 ADD FOREIGN KEY (art2, title2) REFERENCES T535N (art, title) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0002 ADD FOREIGN KEY (art3, title3) REFERENCES T535N (art, title) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0002 ADD FOREIGN KEY (anred) REFERENCES T522G (anred) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0002 ADD FOREIGN KEY (gblnd) REFERENCES T005T (land1) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0002 ADD FOREIGN KEY (sprsl) REFERENCES T002T (sprsl) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0002 ADD FOREIGN KEY (konfe) REFERENCES T516T (konfe) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT0002 ADD FOREIGN KEY (famst) REFERENCES T502T (famst) ON UPDATE CASCADE ON DELETE RESTRICT;
