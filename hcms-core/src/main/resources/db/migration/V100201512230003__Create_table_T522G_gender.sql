CREATE TABLE T522G (
  anred char(1) not null,
  gesch char(1) not null,
  atext character varying(5) not null,
  anrlt character varying(15) not null
);

ALTER TABLE T522G ADD PRIMARY KEY (anred, gesch, atext);
